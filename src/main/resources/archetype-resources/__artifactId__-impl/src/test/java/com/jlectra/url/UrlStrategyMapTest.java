package com.jlectra.url;

import com.jlectra.core.url.Url;
import com.jlectra.core.url.UrlStrategyMap;
import junit.framework.Assert;
import org.junit.Test;

/**
 * User: Lipatov
 * Date: 09.08.13
 */
public class UrlStrategyMapTest {

	@Test
	public void testCase_01_simpleMap() {

		String url = "jlectra.com/news/year_2012/month_08/day_30";

		UrlStrategyMap strategy = new UrlStrategyMap();
		Url params = strategy.parse(url);

		Assert.assertEquals(url, params.getUrl());
		Assert.assertEquals(3, params.map().size());
		Assert.assertEquals("2012", params.map().get("year"));
		Assert.assertEquals("08",   params.map().get("month"));
		Assert.assertEquals("30",   params.map().get("day"));

	}
}
