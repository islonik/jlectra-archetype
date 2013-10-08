package com.jlectra.web.request;

import com.google.inject.Inject;
import com.jlectra.web.request.impl.RequestImpl;
import com.jlectra.core.url.Url;
import com.jlectra.core.url.UrlParser;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ANER0310
 * @date 9/25/13
 */
public class RequestBuilder {
	private final Provider<RequestImpl> requestProvider;

	@Inject
	public RequestBuilder(Provider<RequestImpl> requestProvider) {
		this.requestProvider = requestProvider;
	}

	public Request build(HttpServletRequest servletRequest){
        RequestImpl request = requestProvider.get();
		request.setParameters(servletRequest.getParameterMap());

		return request;
    }
}
