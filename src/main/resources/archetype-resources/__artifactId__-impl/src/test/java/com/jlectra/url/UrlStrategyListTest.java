package com.jlectra.url;

import com.google.common.collect.Lists;
import com.jlectra.core.pages.Page;
import com.jlectra.core.pages.impl.PagesImpl;
import com.jlectra.core.pages.impl.dao.PageDao;
import com.jlectra.core.url.Url;
import com.jlectra.core.url.UrlStrategyList;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Lipatov
 * Date: 09.08.13
 */
public class UrlStrategyListTest {

	@Test
	public void urlParser_testCase01_simplestTest() {

		String url = "jlectra.com/news/2012/07/01";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(Lists.newArrayList(defaultPageCollection()));

		Url params = strategy.parse(url);
		Assert.assertEquals("2012", params.list().get(0));
		Assert.assertEquals("07", params.list().get(1));
		Assert.assertEquals("01", params.list().get(2));
	}

	@Test
	public void urlParser_testCase02_simpleTest() {

		String url = "jlectra.com/news/2012/horror/07/01";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(Lists.newArrayList(defaultPageCollection()));

		Url params = strategy.parse(url);
		Assert.assertEquals("2012", params.list().get(0));
		Assert.assertEquals("horror", params.list().get(1));
		Assert.assertEquals("07", params.list().get(2));
		Assert.assertEquals("01", params.list().get(3));
	}

	@Test
	public void urlParser_testCase03_notHostUrl() {

		String url = "news/2012/horror/07/01";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(Lists.newArrayList(defaultPageCollection()));

		Url params = strategy.parse(url);
		Assert.assertEquals("2012", params.list().get(0));
		Assert.assertEquals("horror", params.list().get(1));
		Assert.assertEquals("07", params.list().get(2));
		Assert.assertEquals("01", params.list().get(3));
	}

	@Test
	public void urlParser_testCase04_wrongPage() {

		String url = "news/2012/horror/07/01";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(Lists.newArrayList(wrongPageCollection()));

		Url params = strategy.parse(url);
		Assert.assertNull(params);
	}

	@Test
	public void urlParser_testCase05_emptyCollection() {

		String url = "news/2012/horror/07/01";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(new ArrayList<Page>());

		Url params = strategy.parse(url);
		Assert.assertNull(params);
	}

	@Test
	public void urlParser_testCase06_backslashInUrl() {

		String url = "jlectra.com\\news\\2012\\07\\01";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(Lists.newArrayList(defaultPageCollection()));

		Url params = strategy.parse(url);
		Assert.assertEquals("2012", params.list().get(0));
		Assert.assertEquals("07", params.list().get(1));
		Assert.assertEquals("01", params.list().get(2));

	}

	@Test
	public void urlParser_testCase07_aLotOfSlashesInUrl() {

		String url = "jlectra.com\\news\\2012\\07\\01//////////////";

		UrlStrategyList strategy = new UrlStrategyList(new PagesImpl(new PageDao()));
		strategy.setPages(Lists.newArrayList(defaultPageCollection()));

		Url params = strategy.parse(url);
		Assert.assertEquals(3, params.list().size());
		Assert.assertEquals("2012", params.list().get(0));
		Assert.assertEquals("07", params.list().get(1));
		Assert.assertEquals("01", params.list().get(2));

	}

	private Collection<Page> defaultPageCollection() {
		Collection<Page> pages = new ArrayList<Page>();
		Page page = new Page();
		page.setId(2L);
		page.setUrl("news");
		page.setTitle("news");
		page.setName("news");
		pages.add(page);
		return pages;
	}

	private Collection<Page> wrongPageCollection() {
		Collection<Page> pages = new ArrayList<Page>();
		Page page = new Page();
		page.setId(3L);
		page.setUrl("admin");
		page.setTitle("admin");
		page.setName("admin");
		pages.add(page);
		return pages;
	}
}
