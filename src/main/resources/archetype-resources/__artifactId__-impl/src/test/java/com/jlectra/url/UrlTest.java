package com.jlectra.url;

import com.jlectra.core.url.Url;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Lipatov
 * Date: 08.08.13
 */
public class UrlTest {
	private static final String URL = "jlectra.com/new/2012/08/30";

	@Test
	public void testCase_01_AsList() {
		List<String> initList = new ArrayList<String>();
		for(int i = 1; i <= 13; i++) {
			initList.add("Test-" + i);
		}

		Url listUrl = new Url(URL, initList);
		
		List<String> resultList = listUrl.list();
		Assert.assertEquals("Test-1", resultList.get(0));
		Assert.assertEquals("Test-2", resultList.get(1));
		Assert.assertEquals("Test-3", resultList.get(2));
		Assert.assertEquals("Test-4", resultList.get(3));
		Assert.assertEquals("Test-5", resultList.get(4));
		Assert.assertEquals("Test-6", resultList.get(5));
		Assert.assertEquals("Test-7", resultList.get(6));
		Assert.assertEquals("Test-8", resultList.get(7));
		Assert.assertEquals("Test-9", resultList.get(8));
		Assert.assertEquals("Test-10", resultList.get(9));
		Assert.assertEquals("Test-11", resultList.get(10));
		Assert.assertEquals("Test-12", resultList.get(11));
		Assert.assertEquals("Test-13", resultList.get(12));

	}

	@Test
	public void testCase_02_simpleAsMap() {
		HashMap<String, String> initMap = new HashMap<String, String>();
		for(int i = 1; i <= 13; i++) {
			initMap.put("key-" + i, "Test-" + i);
		}
		Url mapUrl = new Url(URL, initMap);

		Map<String, String> resultMap = mapUrl.map();
		Assert.assertEquals("Test-1", resultMap.get("key-1"));
		Assert.assertEquals("Test-2", resultMap.get("key-2"));
		Assert.assertEquals("Test-3", resultMap.get("key-3"));
		Assert.assertEquals("Test-4", resultMap.get("key-4"));
		Assert.assertEquals("Test-5", resultMap.get("key-5"));
		Assert.assertEquals("Test-6", resultMap.get("key-6"));
		Assert.assertEquals("Test-7", resultMap.get("key-7"));
		Assert.assertEquals("Test-8", resultMap.get("key-8"));
		Assert.assertEquals("Test-9", resultMap.get("key-9"));
		Assert.assertEquals("Test-10", resultMap.get("key-10"));
		Assert.assertEquals("Test-11", resultMap.get("key-11"));
		Assert.assertEquals("Test-12", resultMap.get("key-12"));
		Assert.assertEquals("Test-13", resultMap.get("key-13"));

	}

	@Test
	public void testCase_03_getParameter() {
		List<String> initList = new ArrayList<String>();
		for(int i = 1; i <= 13; i++) {
			initList.add("Test-" + i);
		}

		Url listUrl = new Url(URL, initList);

		Assert.assertEquals("Test-1", listUrl.getParameter(0));
		Assert.assertEquals("Test-2", listUrl.getParameter(1));
		Assert.assertEquals("Test-3", listUrl.getParameter(2));
		Assert.assertEquals("Test-4", listUrl.getParameter(3));
		Assert.assertEquals("Test-5", listUrl.getParameter(4));
		Assert.assertEquals("Test-6", listUrl.getParameter(5));
		Assert.assertEquals("Test-7", listUrl.getParameter(6));
		Assert.assertEquals("Test-8", listUrl.getParameter(7));
		Assert.assertEquals("Test-9", listUrl.getParameter(8));
		Assert.assertEquals("Test-10", listUrl.getParameter(9));
		Assert.assertEquals("Test-11", listUrl.getParameter(10));
		Assert.assertEquals("Test-12", listUrl.getParameter(11));
		Assert.assertEquals("Test-13", listUrl.getParameter(12));
		Assert.assertNull(listUrl.getParameter(13));
	}

	@Test
	public void testCase_04_getParameter() {
		HashMap<String, String> initMap = new HashMap<String, String>();
		for(int i = 1; i <= 13; i++) {
			initMap.put("key-" + i, "Test-" + i);
		}
		Url mapUrl = new Url(URL, initMap);

		Assert.assertEquals("Test-1", mapUrl.getParameter("key-1"));
		Assert.assertEquals("Test-2", mapUrl.getParameter("key-2"));
		Assert.assertEquals("Test-3", mapUrl.getParameter("key-3"));
		Assert.assertEquals("Test-4", mapUrl.getParameter("key-4"));
		Assert.assertEquals("Test-5", mapUrl.getParameter("key-5"));
		Assert.assertEquals("Test-6", mapUrl.getParameter("key-6"));
		Assert.assertEquals("Test-7", mapUrl.getParameter("key-7"));
		Assert.assertEquals("Test-8", mapUrl.getParameter("key-8"));
		Assert.assertEquals("Test-9", mapUrl.getParameter("key-9"));
		Assert.assertEquals("Test-10", mapUrl.getParameter("key-10"));
		Assert.assertEquals("Test-11", mapUrl.getParameter("key-11"));
		Assert.assertEquals("Test-12", mapUrl.getParameter("key-12"));
		Assert.assertEquals("Test-13", mapUrl.getParameter("key-13"));
		Assert.assertNull(mapUrl.getParameter("key-14"));
	}




}
