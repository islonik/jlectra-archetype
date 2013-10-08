package com.jlectra.web.tpl;

import com.google.inject.ImplementedBy;
import com.jlectra.web.tpl.impl.VelocityEngine;

/**
 * @author ANER0310
 *         Date: 2/12/13
 *         Time: 2:49 PM
 */
@ImplementedBy(VelocityEngine.class)
public interface TplEngine<T> {
	void init();
	boolean isInitialized();

	T getEngine();
}