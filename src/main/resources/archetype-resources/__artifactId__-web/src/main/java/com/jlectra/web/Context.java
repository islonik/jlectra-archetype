package com.jlectra.web;


import com.jlectra.web.request.Request;

import java.io.PrintWriter;

/**
 * @author ANER0310
 * @date 9/26/13
 */
public class Context {
	private static final class CtxHolder{
		PrintWriter writer;
		Request request;
		String url;
	}

	private static final ThreadLocal<CtxHolder> ctx = new ThreadLocal<CtxHolder>();

	public Context(){
		if(ctx.get() == null)
			ctx.set(new CtxHolder());
	}

	public Request getRequest(){
		return ctx.get().request;
	}

	public PrintWriter getWriter(){
		return ctx.get().writer;
	}

	public String getUrl(){
		return ctx.get().url;
	}

	void setRequest(Request request){
		ctx.get().request = request;
	}

	void setWriter(PrintWriter writer){
		ctx.get().writer = writer;
	}

	void setUrl(String url){
		ctx.get().url = url;
	}
}
