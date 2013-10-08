package com.jlectra.utils.db;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * @author ANER0310
 *         Date: 2/26/13
 *         Time: 8:35 PM
 */
public abstract class DaoBase {
	private Provider<EntityManager> em;

	protected EntityManager em(){
		return em.get();
	}

	@Inject
	protected void setEm(Provider<EntityManager> em) {
		this.em = em;
	}
}