package com.jlectra.core.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ANER0310
 *         Date: 8/15/13
 */
@Entity
@Table(name = "jl_components")
public class Component {
	@Id
	private Long id;
	private String name;
	@Column(nullable = true)
	private String description;
	@Column(nullable = false)
	private Boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
