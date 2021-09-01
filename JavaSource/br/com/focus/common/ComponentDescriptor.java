package br.com.focus.common;

import javax.faces.context.FacesContext;

public class ComponentDescriptor {

    private String id;

    private String name;

    private String group;

    private String captionImage;

    private String iconImage;

    private String demoLocation;

    private boolean current;

    private String activeTab;
    
    private boolean newComponent;
    
    public boolean isNewComponent() {
		return newComponent;
	}

	public void setNewComponent(boolean newComponent) {
		this.newComponent = newComponent;
	}

	public ComponentDescriptor() {
        this.id = "";
        this.name = "";
        this.captionImage = "";
        this.iconImage = "";
        this.current = false;
        this.activeTab = "usage";
        this.newComponent=false;
    }

    public String getCaptionImage() {
        return captionImage;
    }

    public void setCaptionImage(String captionImage) {
        this.captionImage = captionImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getIconImage() {
        return iconImage;
    }

    public void setIconImage(String iconImage) {
        this.iconImage = iconImage;
    }

    public String getDemoLocation() {
        return demoLocation;
    }

    public void setDemoLocation(String demoLocation) {
        this.demoLocation = demoLocation;
    }

    public String getContextRelativeDemoLocation() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc.getExternalContext().getRequestContextPath() + getDemoLocation();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTagUsageLocation() {
        return demoLocation.replaceAll("\\.jsf[\\s]*$", "");
    }

    /**
     * Gets value of activeTab field.
     * @return value of activeTab field
     */
    public String getActiveTab() {
        return activeTab;
    }

    /**
     * Set a new value for activeTab field.
     * @param activeTab a new value for activeTab field
     */
    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
    }

}
