package com.jlectra.core.storage.model;

import javax.persistence.*;

@Entity
@Table(name = "jl_attrs")
public class Attribute extends StorageEntity {
    @JoinColumn(name = "type")
    @ManyToOne
    private AttributeType type;

    @JoinColumn(name = "schema")
    @ManyToOne
    private Schema schema;

    private String name;
	private String alias;

    @Column(name = "multiple")
    private Boolean isMultiple;

    @Column(name = "show_order")
    private Long order;

    private String description;

	public AttributeType getType() {
		return type;
	}

	public void setType(AttributeType type) {
		this.type = type;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Boolean getMultiple() {
		return isMultiple;
	}

	public void setMultiple(Boolean multiple) {
		isMultiple = multiple;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
