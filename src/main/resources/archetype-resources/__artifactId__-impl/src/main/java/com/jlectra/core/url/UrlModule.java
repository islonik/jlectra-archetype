package com.jlectra.core.url;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;

/**
 * User: Lipatov
 * Date: 09.08.13
 */
public class UrlModule extends AbstractModule {

	@Override
	protected void configure() {
		MapBinder<String, UrlStrategy> mapBinder = MapBinder.newMapBinder(
				binder(),
				String.class,
				UrlStrategy.class);
		mapBinder.addBinding("list").to(UrlStrategyList.class).in(Scopes.NO_SCOPE);
		mapBinder.addBinding("map").to(UrlStrategyMap.class).in(Scopes.NO_SCOPE);
	}
}
