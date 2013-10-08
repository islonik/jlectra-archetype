package com.jlectra.core.components;

import com.google.inject.ImplementedBy;
import com.jlectra.core.components.impl.ComponentsImpl;

/**
 * @author ANER0310
 *         Date: 8/15/13
 */
@ImplementedBy(ComponentsImpl.class)
public interface Components {
	public Component get(Long id);
	public void install(Component cmp);
	public void uninstall(Component cmp);
	public void disable(Component cmp);
	public void enable(Component cmp);
}