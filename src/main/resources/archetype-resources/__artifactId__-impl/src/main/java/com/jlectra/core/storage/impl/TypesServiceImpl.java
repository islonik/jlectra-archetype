package com.jlectra.core.storage.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jlectra.core.storage.TypesService;
import com.jlectra.core.storage.impl.dao.TypeDao;
import com.jlectra.core.storage.model.EntityType;

import java.util.Collection;

/**
 * @author ANER0310
 *         Date: 6/26/13
 */
public class TypesServiceImpl implements TypesService {
	private TypeDao dao;

	private final Long rootType;

	@Inject
	public TypesServiceImpl(TypeDao dao, @Named("ncat.ot_root_id") Long rootType) {
		this.dao = dao;
		this.rootType = rootType;
	}

	public EntityType byId(Long id){
		return dao.findById(id);
	}

	public EntityType getRoot(){
		return dao.findById(rootType);
	}

	public Collection<EntityType> getChildren(Long id){
		return dao.findByParent(byId(id));
	}
}