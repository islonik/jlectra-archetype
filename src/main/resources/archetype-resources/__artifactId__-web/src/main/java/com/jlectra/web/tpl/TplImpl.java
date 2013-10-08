package com.jlectra.web.tpl;


import javax.inject.Inject;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author ANER0310
 *         Date: 2/12/13
 *         Time: 12:13 PM
 */
public class TplImpl implements Tpl {
	Render render;
	Template tpl;

	@Inject
	public TplImpl(Render render) {
		this.render = render;

		tpl = new Template();
	}

	public void append(String name, Object value){
		tpl.append(name, value);
	}

	public String render(String filename){
		return render(filename, new StringWriter()).toString();
	}

	public <T extends Writer> T render(String filename, T writer){
		tpl.setTemplate(filename);
		render.render(tpl, writer);
		return writer;
	}
}