package com.jlectra.web.tpl.impl;

import com.jlectra.web.tpl.Render;
import com.jlectra.web.tpl.Template;
import com.jlectra.web.tpl.TplEngine;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author ANER0310
 *         Date: 2/12/13
 *         Time: 3:03 PM
 */
@Singleton
public class VelocityRender implements Render {

	TplEngine<VelocityEngine> engine;

	@Inject
	public VelocityRender(TplEngine<VelocityEngine> engine) {
		this.engine = engine;

		if(!engine.isInitialized()){
			engine.init();
		}
	}

	@Override
	public String render(Template tpl) {
		StringWriter writer = new StringWriter();


		render(tpl, writer);

		return writer.toString();
	}

	@Override
	public void render(Template tpl, Writer writer) {

		VelocityContext ctx = new VelocityContext();

		for(Map.Entry<String, Object> entry : tpl.getVars().entrySet()){
			ctx.put(entry.getKey(), entry.getValue());
		}

		org.apache.velocity.Template vlTpl = Velocity.getTemplate("templates/" + tpl.getTemplate());
		vlTpl.merge(ctx, writer);
	}
}