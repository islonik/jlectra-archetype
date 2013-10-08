package com.jlectra.web.blocks;

import com.jlectra.web.request.Request;
import com.jlectra.web.tpl.Tpl;

import java.util.Collection;
import java.util.List;

/**
 * @author ANER0310
 *         Date: 9/25/13
 */
public interface Block {
	public String process(List<String> params);
}