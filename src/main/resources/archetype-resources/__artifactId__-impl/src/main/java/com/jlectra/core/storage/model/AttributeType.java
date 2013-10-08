package com.jlectra.core.storage.model;

import javax.persistence.*;

@Entity
@Table(name = "jl_attr_types")
public class AttributeType extends StorageEntity {

	private String name;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
