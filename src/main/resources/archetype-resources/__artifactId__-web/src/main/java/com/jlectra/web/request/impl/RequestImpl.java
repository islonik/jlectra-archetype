package com.jlectra.web.request.impl;

import com.jlectra.core.url.Url;
import com.jlectra.web.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author ANER0310
 */
public class RequestImpl implements Request{
	private final static Logger log = LoggerFactory.getLogger(RequestImpl.class);

	private final Converter converter;

    private Map<String, ? extends Object> params;
	private Url url;

	@Inject
	public RequestImpl(Converter converter) {
		this.converter = converter;
	}

	@Override
    public <T> T getParameter(String parameter, Class<T> type) {
		if(params.containsKey(parameter)){
			return converter.convert(params.get(parameter), type);
		} else{
			log.warn(
					"Requested parameter [name={}] which does not exists",
					parameter);
			return null;
		}
    }

	public void setParameters(Map<String, ? extends Object> params){
		this.params = params;
	}
}
