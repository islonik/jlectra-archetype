package com.jlectra.core.storage.impl.dao;

import com.jlectra.core.storage.model.Attribute;
import com.jlectra.utils.db.DaoBase;

public class AttrDao extends DaoBase {
    public Attribute findById(Long id) {
        return em().find(Attribute.class, id);
    }

    public Attribute create(Attribute attribute) {
        return em().merge(attribute);
    }
}
