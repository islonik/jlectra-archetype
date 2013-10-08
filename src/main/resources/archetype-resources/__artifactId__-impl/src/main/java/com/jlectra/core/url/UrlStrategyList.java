package com.jlectra.core.url;

import com.google.common.collect.Lists;
import com.jlectra.core.pages.Page;
import com.jlectra.core.pages.Pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Lipatov
 * Date: 09.08.13
 */
public class UrlStrategyList extends UrlStrategy {

	private final static Logger log = LoggerFactory.getLogger(UrlStrategyList.class);

	private Pages service;
    private List<Page> pages;

	@Inject
	public UrlStrategyList(Pages service) {
		this.service = service;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		if(this.pages == null) {
			this.pages = new ArrayList<Page>();
		}
		this.pages = pages;
	}
	
	public Url parse(String url) {
		
		if(pages == null) {
			this.pages = Lists.newArrayList(this.service.findByUrl(url));
		}

		Page page = getFirstPage(pages);
		if(page == null) {
			return null;
		}

		url = getPreparedUrl(page, url);
		if(url == null) {
			return null;
		}

		Url listUrl = new Url(url, getParams(url));

		return listUrl;
	}

	protected Page getFirstPage(Collection<Page> pages) {
		for(Page page : pages) {
			return page;
		}
		return null;
	}

	protected String getPreparedUrl(Page page, String url) {
		String relativeUrl = page.getUrl();
		int index = url.indexOf(relativeUrl);
		if(index == -1) {
			return null;
		}
		url = url.substring(index + relativeUrl.length(), url.length());
		return url;
	}
}
