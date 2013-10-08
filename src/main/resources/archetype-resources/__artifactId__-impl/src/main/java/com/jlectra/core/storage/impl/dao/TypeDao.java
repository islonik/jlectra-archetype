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
package com.jlectra.core.storage.impl.dao;

import com.jlectra.core.storage.model.EntityType;
import com.jlectra.utils.db.DaoBase;

import java.util.Collection;

public class TypeDao extends DaoBase {
	public EntityType findById(Long id){
		return em().find(EntityType.class,id);
	}

	public Collection<EntityType> findByParent(EntityType oType){
		return em()
				.createNamedQuery("Type.FindByParent")
				.setParameter("parent", oType)
				.getResultList();
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
