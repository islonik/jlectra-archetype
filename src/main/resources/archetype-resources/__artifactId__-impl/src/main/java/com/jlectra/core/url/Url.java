package com.jlectra.core.url;

import java.util.*;

/**
 * User: Nikita Lipatov
 * Date: 7/28/13
 * Time: 1:56 PM
 */
public class Url {

	private String url;
    
	private List<String> listParams = new ArrayList<String>();
	private HashMap<String, String> mapParams  = new HashMap<String, String>();

	public Url(String url, List<String> values) {
        List<? super Integer> c = new ArrayList<Number>();
		this.url = url;
		this.listParams = values;
	}
	
	public Url(String url, HashMap<String, String> map) {
		this.url = url;
		this.mapParams = map;
	}

	public String getParameter(int index) {
		if(listParams.size() > index) {

			return listParams.get(index);
		}
		return null;
	}
	
	public String getParameter(String key) {
		return mapParams.get(key);
	}
	
    public String getUrl() {
        return url;
    }

    public Map<String, String> map() {
		return mapParams;
	}
	
	public List<String> list() {
		return listParams;
	}




}
