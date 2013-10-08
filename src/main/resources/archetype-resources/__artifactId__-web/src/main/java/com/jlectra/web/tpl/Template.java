package com.jlectra.web.tpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ANER0310
 *         Date: 2/12/13
 *         Time: 2:27 PM
 */
public class Template {
	Map<String, Object> vars = new HashMap<String, Object>();

	String template;

	public Template() {
	}

	public Template(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void append(String name, Object value){
		vars.put(name, value);
	}

	public Map<String, Object> getVars(){
		return Collections.unmodifiableMap(vars);
	}
}