package com.jlectra.core.storage;

import com.google.inject.ImplementedBy;
import com.jlectra.core.storage.impl.AttrTypesServiceImpl;
import com.jlectra.core.storage.model.AttributeType;

@ImplementedBy(AttrTypesServiceImpl.class)
public interface AttrTypesService {
    public AttributeType byId(Long id);
}
