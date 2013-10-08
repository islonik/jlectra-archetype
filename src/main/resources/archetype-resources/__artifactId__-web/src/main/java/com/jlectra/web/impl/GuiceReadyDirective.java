package com.jlectra.web.impl;

import com.jlectra.web.GuiceHolder;
import org.apache.velocity.runtime.directive.Directive;

/**
 * @author ANER0310
 *         Date: 9/25/13
 */
abstract class GuiceReadyDirective extends Directive{
	public GuiceReadyDirective() {
		GuiceHolder.get().injectMembers(this);
	}
}