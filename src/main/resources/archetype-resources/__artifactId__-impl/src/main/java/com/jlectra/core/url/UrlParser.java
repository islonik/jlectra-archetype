package com.jlectra.core.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

/**
 * User: Nikita Lipatov
 * Date: 7/28/13
 * Time: 1:57 PM
 */
public class UrlParser {

	private final static Logger log = LoggerFactory.getLogger(UrlParser.class);
	private final Map<String, UrlStrategy> strategies;

    private UrlStrategy urlStrategy;

	@Inject
	public UrlParser(Map<String, UrlStrategy> strategies) {
		this.strategies = strategies;
	}

	public Url parse(String url){
		//TODO: нахрена urlStrategy локальной переменной в классе сделала, если каждый раз она перезаписывается?
		urlStrategy = getUrlStrategy(url);

		return urlStrategy.parse(url);
	}

	protected UrlStrategy getUrlStrategy(String url) {
		return (url.contains("_"))
				? strategies.get("map")
				: strategies.get("list");
	}


}
