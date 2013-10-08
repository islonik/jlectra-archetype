package com.jlectra.core.components.impl;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.jlectra.core.components.Component;
import com.jlectra.core.components.Components;

/**
 * @author ANER0310
 *         Date: 8/15/13
 */
public class ComponentsImpl implements Components{

	ComponentDao dao;

	@Inject
	public ComponentsImpl(ComponentDao dao) {
		this.dao = dao;
	}

	@Override
	public Component get(Long id) {
		return dao.findById(id);
	}

	@Override
	public void install(Component cmp) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public void uninstall(Component cmp) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	@Transactional
	public void disable(Component cmp) {
		cmp = dao.findById(cmp.getId());
		cmp.setEnabled(false);
	}

	@Override
	@Transactional
	public void enable(Component cmp) {
		cmp = dao.findById(cmp.getId());
		cmp.setEnabled(true);
	}
}