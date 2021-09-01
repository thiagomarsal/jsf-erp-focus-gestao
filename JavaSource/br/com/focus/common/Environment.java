package br.com.focus.common;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;

public class Environment {
	@SuppressWarnings("unchecked")
	private Map params = new HashMap();
	@SuppressWarnings("unused")
	private String version; 
	@SuppressWarnings("unchecked")
	public Map getParams() {
		return params;
	}

	@SuppressWarnings("unchecked")
	public void setParams(Map params) {
		this.params = params;
	}
	
	public String getVersion() {
		String shortVersion = FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createValueExpression(FacesContext.getCurrentInstance().getELContext(), "#{a4j.version}", String.class).getValue(FacesContext.getCurrentInstance().getELContext()).toString();
		return shortVersion.substring(0, shortVersion.indexOf("$Date"));
	}
}
