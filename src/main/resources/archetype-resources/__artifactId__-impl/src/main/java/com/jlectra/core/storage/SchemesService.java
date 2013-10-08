package com.jlectra.core.storage;

import com.google.inject.ImplementedBy;
import com.jlectra.core.storage.impl.SchemesServiceImpl;
import com.jlectra.core.storage.model.Schema;

import java.util.Collection;

@ImplementedBy(SchemesServiceImpl.class)
public interface SchemesService {
	public Schema byId(Long id);

	public Collection<Schema> byParent(Long parentId);
}