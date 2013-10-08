package com.jlectra.core.pages.impl.dao;

import com.jlectra.core.pages.Page;
import com.jlectra.utils.db.DaoBase;

import java.util.Collection;

/**
 * User: Nikita Lipatov
 * Date: 7/27/13
 * Time: 10:56 PM
 */
public class PageDao extends DaoBase {

    public Page findById(Long id) {
        return em().find(Page.class, id);
    }

    public Page create(Page page) {
        return em().merge(page);
    }

	public Collection<Page> findByName(String name){
		return em().createNamedQuery("Page.FindByName")
				   .setParameter("name", name)
				   .getResultList();
	}

	public Collection<Page> findByAlias(String alias){
		return em().createNamedQuery("Page.FindByAlias")
				   .setParameter("alias", alias)
				   .getResultList();
	}

	public Collection<Page> findByTitle(String title){
		return em().createNamedQuery("Page.FindByTitle")
				   .setParameter("title", title)
				   .getResultList();
	}

    public Collection<Page> findByUrl(String url){
        return em()
                .createNamedQuery("Page.FindByUrl")
                .setParameter("url", "%" + url + "%")
                .getResultList();
    }
}
