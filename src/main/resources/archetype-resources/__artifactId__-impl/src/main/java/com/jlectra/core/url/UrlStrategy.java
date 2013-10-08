package com.jlectra.core.url;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * User: Lipatov
 * Date: 09.08.13
 */
public abstract class UrlStrategy {

	public abstract Url parse(String url);

	protected List<String> getParams(String url) {
		List<String> params = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(url, "/\\");
		while(stringTokenizer.hasMoreTokens()) {
			String token = stringTokenizer.nextToken();
			params.add(token);
		}
		return params;
	}
}
