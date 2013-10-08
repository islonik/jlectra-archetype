package com.jlectra.core.storage;

import com.google.inject.ImplementedBy;
import com.jlectra.core.storage.impl.TypesServiceImpl;
import com.jlectra.core.storage.model.EntityType;

import java.util.Collection;

@ImplementedBy(TypesServiceImpl.class)
public interface TypesService {
	public EntityType byId(Long id);

	public EntityType getRoot();

	public Collection<EntityType> getChildren(Long id);
}