package com.jlectra.core.storage.impl.dao;

import com.jlectra.core.storage.model.AttributeType;
import com.jlectra.utils.db.DaoBase;

public class AttrTypeDao extends DaoBase {

    public AttributeType findById(Long id) {
        return em().find(AttributeType.class, id);
    }
}
