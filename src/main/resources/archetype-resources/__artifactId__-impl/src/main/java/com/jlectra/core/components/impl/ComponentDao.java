package com.jlectra.core.components.impl;

import com.jlectra.core.components.Component;
import com.jlectra.utils.db.DaoBase;

/**
 * @author ANER0310
 *         Date: 8/15/13
 */
public class ComponentDao extends DaoBase{
	public Component findById(Long id){
		return em().find(Component.class, id);
	}
}