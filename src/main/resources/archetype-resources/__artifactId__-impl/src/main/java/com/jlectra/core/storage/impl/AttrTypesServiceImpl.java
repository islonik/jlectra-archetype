package com.jlectra.core.storage.impl;

import com.google.inject.Inject;
import com.jlectra.core.storage.AttrTypesService;
import com.jlectra.core.storage.impl.dao.AttrTypeDao;
import com.jlectra.core.storage.model.AttributeType;

public class AttrTypesServiceImpl implements AttrTypesService {
    AttrTypeDao dao;

    @Inject
	AttrTypesServiceImpl(AttrTypeDao attributeTypeDao) {
        this.dao = attributeTypeDao;
    }

    public AttributeType byId(Long id) {
        return dao.findById(id);
    }
}
