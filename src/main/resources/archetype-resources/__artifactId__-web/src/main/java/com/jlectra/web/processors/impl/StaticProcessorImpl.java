package com.jlectra.web.processors.impl;

import com.google.inject.Singleton;
import com.jlectra.web.processors.Processor;
import com.jlectra.web.tpl.TplImpl;

import javax.inject.Inject;

/**
 * @author ANER0310
 * @date 9/25/13
 */
@Singleton
public class StaticProcessorImpl implements Processor {
	private final TplImpl tpl;

	@Inject
	public StaticProcessorImpl(TplImpl tpl) {
		this.tpl = tpl;
	}

	@Override
	public String process() {
		return tpl.render("static/index.tpl");
	}
}
