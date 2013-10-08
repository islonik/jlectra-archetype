package com.jlectra.core.storage.model;

import com.jlectra.core.components.Component;

import javax.persistence.*;

/**
 * @author ANER0310
 *         Date: 8/15/13
 */
@MappedSuperclass
public abstract class StorageEntity {
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Component owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Component getOwner() {
		return owner;
	}

	public void setOwner(Component owner) {
		this.owner = owner;
	}
}