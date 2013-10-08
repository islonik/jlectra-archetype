package com.jlectra.web.tpl;

import com.google.inject.ImplementedBy;
import com.jlectra.web.tpl.impl.VelocityRender;

import java.io.Writer;

/**
 * @author ANER0310
 *         Date: 2/12/13
 *         Time: 2:46 PM
 */
@ImplementedBy(VelocityRender.class)
public interface Render {
	String render(Template tpl);
	void render(Template tmp, Writer writer);
}