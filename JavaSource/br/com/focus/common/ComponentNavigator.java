package br.com.focus.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.faces.FacesException;
import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

public class ComponentNavigator {
    private String lastCompId = null;

    @SuppressWarnings("unchecked")
	private List components = null;

    private ComponentDescriptor currentComponent;

    @SuppressWarnings("unchecked")
	private List componentGroups = null;

    public boolean getHasCurrentComponent() {
        return currentComponent != null;
    }

    public ComponentDescriptor getCurrentComponent() {
        String id = getComponentParam("c");
        if (id != null) {
            setCurrentComponent(findComponentById(id));
            lastCompId = id;
        } else if (lastCompId != null) {
            setCurrentComponent(findComponentById(lastCompId));
        } else {
            String uri = getComponentUri();
            setCurrentComponent(findComponentByUri(uri));
        }

        // set active tab for current component if any
        if (null != currentComponent) {
            String tab = getComponentParam("tab");
            if (null != tab) {
                currentComponent.setActiveTab(tab);
            }
        }

        return currentComponent;
    }

    private String getComponentUri() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return ((HttpServletRequest) fc.getExternalContext().getRequest()).getRequestURI();
    }

    private String getComponentParam(String name) {
        FacesContext fc = FacesContext.getCurrentInstance();
        String param = (String) fc.getExternalContext().getRequestParameterMap().get(name);
        if (param != null && param.trim().length() > 0) {
            return param;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
	private List components_() {
        if (components == null) {
            loadComponents();
        }
        return components;
    }

    @SuppressWarnings("unchecked")
	public ComponentDescriptor findComponentByUri(String uri) {
        Iterator it = components_().iterator();
        while (it.hasNext()) {
            ComponentDescriptor component = (ComponentDescriptor) it.next();
            if (uri.endsWith(component.getDemoLocation())) {
                return component;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
	public ComponentDescriptor findComponentById(String id) {
        Iterator it = components_().iterator();
        while (it.hasNext()) {
            ComponentDescriptor component = (ComponentDescriptor) it.next();
            if (component.getId().equals(id)) {
                return component;
            }
        }
        return null;
    }

    public void setCurrentComponent(ComponentDescriptor currentComponent) {
        if (currentComponent == null) {
            this.currentComponent = (ComponentDescriptor) components_().get(0);
        }
        this.currentComponent = currentComponent;
    }

    @SuppressWarnings("unchecked")
	public List getComponentGroups() {
        return componentGroups;
    }

    @SuppressWarnings("unchecked")
	public void setComponentGroups(List componentGroups) {
        this.componentGroups = componentGroups;
    }

    @SuppressWarnings("unchecked")
	private List getFilteredComponents(String group) {
        List ret = new ArrayList();
        Iterator it = getComponents().iterator();
        while (it.hasNext()) {
            ComponentDescriptor desc = (ComponentDescriptor) it.next();
            if (desc.getGroup().equals(group)) {
                ret.add(desc);
            }
        }
        return ret;
    }

    private boolean checkNewComponents(List<ComponentDescriptor> groups){
    	for (ComponentDescriptor component : groups) {
			if (component.isNewComponent()) return true;
		}
    	return false;
    }
    
    @SuppressWarnings("unchecked")
	public boolean isVendasHasNew() {
        return checkNewComponents(getFilteredComponents("vendas"));
    }

    @SuppressWarnings("unchecked")
	public boolean isCadastroHasNew() {
        return checkNewComponents(getFilteredComponents("cadastro"));
    }

    @SuppressWarnings("unchecked")
	public boolean isMovimentoHasNew() {
        return checkNewComponents(getFilteredComponents("movimento"));
    }

    @SuppressWarnings("unchecked")
	public boolean isRelatoriosHasNew() {
        return checkNewComponents(getFilteredComponents("relatorios"));
    }

 // ************************************************************************************
    
    @SuppressWarnings("unchecked")
	public List getVendasComponents() {
        return getFilteredComponents("vendas");
    }

    @SuppressWarnings("unchecked")
	public List getCadastroComponents() {
        return getFilteredComponents("cadastro");
    }

    @SuppressWarnings("unchecked")
	public List getMovimentoComponents() {
        return getFilteredComponents("movimento");
    }

    @SuppressWarnings("unchecked")
	public List getRelatoriosComponents() {
        return getFilteredComponents("relatorios");
    }

    // ************************************************************************************    
    @SuppressWarnings("unchecked")
	public List getComponents() {
        Iterator it = components_().iterator();
        ComponentDescriptor cur = getCurrentComponent();
        while (it.hasNext()) {
            ComponentDescriptor desc = (ComponentDescriptor) it.next();
            if (desc.equals(cur)) {
                desc.setCurrent(true);
            } else {
                desc.setCurrent(false);
            }
        }
        return components;
    }

    @SuppressWarnings("unchecked")
	public void setComponents(List components) {
        this.components = components;
    }

    @SuppressWarnings("unchecked")
	private void loadComponents() {
        Properties props = new Properties();
        List temp = new ArrayList();
        try {
            InputStream is = this.getClass().getResourceAsStream(
                    "/br/com/focus/common/components.properties");
            props.load(is);
        } catch (Exception e) {
            throw new FacesException(e);
        }
        Set entries = props.entrySet();
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            ComponentDescriptor desc = new ComponentDescriptor();
            desc.setId(e.getKey().toString().trim());
            StringTokenizer toc = new StringTokenizer(e.getValue().toString(), ",");
            // #id=group,name,iconImage,captionImage,demoLocation
            desc.setGroup(toc.nextToken().trim());
            desc.setName(toc.nextToken().trim());
            desc.setIconImage(toc.nextToken().trim());
            desc.setCaptionImage(toc.nextToken().trim());
            desc.setDemoLocation(toc.nextToken().trim());
            if (toc.hasMoreElements()) 
            	if ("new".equals(toc.nextToken().trim()))
            		desc.setNewComponent(true);
            else desc.setNewComponent(false);
            temp.add(desc);
        }
        Collections.sort(temp, new Comparator() {
            public int compare(Object o1, Object o2) {
                ComponentDescriptor d1 = (ComponentDescriptor) o1;
                ComponentDescriptor d2 = (ComponentDescriptor) o2;
                return d1.getName().compareTo(d2.getName());
            }
        });
        setComponents(temp);
        setCurrentComponent((ComponentDescriptor) temp.get(0));
    }

    /**
     * Invoked when example tab panel switched
     * 
     * @param event
     *                a ValueChangeEvent object
     */
    public void tabPanelSwitched(ValueChangeEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
        String viewId = facesContext.getViewRoot().getViewId();
        String actionURL = viewHandler.getActionURL(facesContext, viewId);
        actionURL = patchURL(actionURL, "tab", getCurrentComponent().getActiveTab());
        try {
            facesContext.getExternalContext().redirect(actionURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds/replaces a query parameter in a given "GET request URL"-like string.
     *
     * @param param
     *                name of query parameter
     * @param value
     *                value of query parameter
     * @return string representing parched url
     */
    private String patchURL(String url, String param, String value) {
        String queryPair = param + "=" + value;
        url.replaceAll("[\\?]" + param + "=[\\w]*", "?" + queryPair);
        url.replaceAll("[&]" + param + "=[\\w]*", "&" + queryPair);

        if (!url.contains("?" + param + "=") && !url.contains("&" + param + "=")) {
            if (url.contains("?")) {
                url += "&";
            } else {
                url += "?";
            }
            url += queryPair;
        }

        return url;
    }

}
