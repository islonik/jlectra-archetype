package com.jlectra.core.storage;

import com.google.inject.ImplementedBy;
import com.jlectra.core.storage.impl.AttrsServiceImpl;
import com.jlectra.core.storage.model.Attribute;

@ImplementedBy(AttrsServiceImpl.class)
public interface AttrsService {
    public Attribute byId(Long id);
    public Attribute create(Attribute attribute);
}
