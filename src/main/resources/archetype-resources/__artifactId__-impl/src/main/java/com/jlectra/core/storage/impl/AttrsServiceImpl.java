package com.jlectra.core.storage.impl;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.jlectra.core.storage.AttrsService;
import com.jlectra.core.storage.impl.dao.AttrDao;
import com.jlectra.core.storage.model.Attribute;


public class AttrsServiceImpl implements AttrsService {
    AttrDao dao;

    @Inject
    public AttrsServiceImpl(AttrDao dao) {
        this.dao = dao;
    }

    public Attribute byId(Long id) {
        return dao.findById(id);
    }

    @Transactional
    public Attribute create(Attribute attribute) {
        return dao.create(attribute);
    }
}
