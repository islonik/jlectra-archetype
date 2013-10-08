package com.jlectra.core.storage.impl;

import com.google.inject.Inject;
import com.jlectra.core.storage.SchemesService;
import com.jlectra.core.storage.impl.dao.SchemaDao;
import com.jlectra.core.storage.model.Schema;

import java.util.Collection;

/**
 * @author ANER0310
 *         Date: 7/16/13
 */
public class SchemesServiceImpl implements SchemesService {
	SchemaDao dao;

	@Inject
	public SchemesServiceImpl(SchemaDao dao) {
		this.dao = dao;
	}

	public Schema byId(Long id){
		return dao.findById(id);
	}

	public Collection<Schema> byParent(Long parentId){
		return dao.findByParent(byId(parentId));
	}
}