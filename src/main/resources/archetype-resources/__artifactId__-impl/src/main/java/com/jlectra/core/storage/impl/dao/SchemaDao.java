package com.jlectra.core.storage.impl.dao;

import com.jlectra.core.storage.model.Schema;
import com.jlectra.utils.db.DaoBase;

import java.util.Collection;

public class SchemaDao extends DaoBase {

	public Schema findById(Long id){
		return em().find(Schema.class,id);
	}

	public Collection<Schema> findByParent(Schema schema){
		return em()
				.createNamedQuery("Schema.FindByParent")
				.setParameter("parent", schema)
				.getResultList();
	}
}