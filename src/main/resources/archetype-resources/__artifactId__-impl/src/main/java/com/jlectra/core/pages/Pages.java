package com.jlectra.core.pages;

import com.google.inject.ImplementedBy;
import com.jlectra.core.pages.impl.PagesImpl;

import java.util.Collection;

/**
 * User: Nikita Lipatov
 * Date: 7/27/13
 * Time: 10:52 PM
 */
@ImplementedBy(PagesImpl.class)
public interface Pages {


    public Collection<Page> findByUrl(String url);
}
