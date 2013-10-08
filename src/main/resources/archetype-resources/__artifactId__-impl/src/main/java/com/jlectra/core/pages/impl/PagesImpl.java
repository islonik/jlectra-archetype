package com.jlectra.core.pages.impl;

import com.google.inject.Inject;
import com.jlectra.core.pages.Page;
import com.jlectra.core.pages.Pages;
import com.jlectra.core.pages.impl.dao.PageDao;

import java.util.Collection;

/**
 * User: Nikita Lipatov
 * Date: 7/27/13
 * Time: 10:52 PM
 */
public class PagesImpl implements Pages {
    private PageDao dao;

    @Inject
    public PagesImpl(PageDao dao) {
        this.dao = dao;
    }

    @Override
    public Collection<Page> findByUrl(String url) {
        return dao.findByUrl(url);
    }
}
