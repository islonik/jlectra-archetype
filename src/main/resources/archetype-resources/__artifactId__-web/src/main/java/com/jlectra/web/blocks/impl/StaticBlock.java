package com.jlectra.web.blocks.impl;

import com.jlectra.web.Context;
import com.jlectra.web.blocks.Block;
import com.jlectra.web.tpl.TplImpl;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URI;
import java.util.List;

/**
 * @author ANER0310
 *         Date: 9/25/13
 */
@Singleton
public class StaticBlock implements Block {

	private final Context ctx;
	private final TplImpl tpl;

	@Inject
	public StaticBlock(Context ctx, TplImpl tpl) {
		this.ctx = ctx;
		this.tpl = tpl;
	}

	@Override
	public String process(List<String> params) {
		String url = ctx.getUrl();
		URI uri = URI.create(url);
		String path = uri.getPath();

		return tpl.render(String.format("static/%s/%s", path, params.get(0)));
	}
}