package com.jlectra.web;

import com.jlectra.web.processors.Processor;
import com.jlectra.web.request.Request;
import com.jlectra.web.request.RequestBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ANER0310
 *         Date: 9/25/13
 */
@Singleton
public class JLectra extends HttpServlet{
	private final Processor processor;
	private final RequestBuilder rqBuilder;

	@Inject
	public JLectra(Processor processor, RequestBuilder rqBuilder) {
		this.processor = processor;
		this.rqBuilder = rqBuilder;
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse httpServletResponse)
			throws ServletException, IOException
	{
		Request rq = rqBuilder.build(request);

		Context ctx = new Context();
		ctx.setRequest(rq);
		ctx.setWriter(httpServletResponse.getWriter());
		ctx.setUrl(request.getRequestURL().toString());

		httpServletResponse.getWriter().write(processor.process());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doRequest(request, response);
	}
}