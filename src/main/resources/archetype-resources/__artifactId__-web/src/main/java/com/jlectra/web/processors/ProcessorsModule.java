package com.jlectra.web.processors;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.jlectra.web.processors.impl.StaticProcessorImpl;

/**
 * @author ANER0310
 * @date 9/25/13
 */
public class ProcessorsModule extends AbstractModule {
	@Override
	protected void configure() {
		MapBinder<String, Processor> binder = MapBinder.newMapBinder(binder(),
				String.class, Processor.class);

		binder.addBinding("static").to(StaticProcessorImpl.class);
	}
}
