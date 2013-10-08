package com.jlectra.core.url;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * User: Lipatov
 * Date: 09.08.13
 */
public class UrlStrategyMap extends UrlStrategy {

	public Url parse(String url) {

		HashMap<String, String> result = new HashMap<String, String>();
		List<String> tokens = getParams(url);
		for(String token : tokens) {
			StringTokenizer stringTokenizer = new StringTokenizer(token, "_");
			while(stringTokenizer.countTokens() == 2) {
				String key   = stringTokenizer.nextToken();
				String value = stringTokenizer.nextToken();
				result.put(key, value);
			}
		}
		Url mapUrl = new Url(url, result);

		return mapUrl;
	}
	

}
