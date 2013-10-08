package com.jlectra.core.storage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "jl_types")
@NamedQueries({
		@NamedQuery(
				name = "Type.FindByParent",
				query = "SELECT OType FROM EntityType OType WHERE OType.parent = :parent ORDER BY OType.name")
})
public class EntityType extends StorageEntity {

	@JoinColumn(name = "parent")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private EntityType parent;

	private String name;

	@Column(nullable = true)
	private String description;

	private String alias;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Collection<EntityType> children;

	@XmlTransient
	public EntityType getParent() {
		return parent;
	}

	@XmlTransient
	public void setParent(EntityType parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@XmlTransient
	public Collection<EntityType> getChildren() {
		return children;
	}

	@XmlTransient
	public void setChildren(Collection<EntityType> children) {
		this.children = children;
	}

	@XmlAttribute(name = "isParent")
	public boolean isParent() {
		return children.size() > 0;
	}
}