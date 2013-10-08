/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2013 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
package com.jlectra.core.storage.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@NamedQueries({
		@NamedQuery(
				name = "Schema.FindByParent",
				query = "SELECT ASCHEMA FROM Schema ASCHEMA WHERE ASCHEMA.parent = :parent ORDER BY ASCHEMA.name"
		)
})
@Entity
@Table(name = "jl_schemes")
public class Schema extends StorageEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent")
	private Schema parent;

	private String name;

	@Column(nullable = true)
	private String description;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private Collection<Schema> children;

	public Schema getParent() {
		return parent;
	}

	public void setParent(Schema parent) {
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

	@XmlAttribute(name = "isParent")
	public boolean isParent() {
		return children.size() > 0;
	}

	@XmlTransient
	public Collection<Schema> getChildren() {
		return children;
	}

	@XmlTransient
	public void setChildren(Collection<Schema> children) {
		this.children = children;
	}
}
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER. 
 
 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.
 
 Copyright (c) 1995-2013 NetCracker Technology Corp.
 
 All Rights Reserved.
*/
