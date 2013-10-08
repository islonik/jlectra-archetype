package com.jlectra.web;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.jlectra.web.blocks.BlocksModule;
import com.jlectra.web.processors.Processor;
import com.jlectra.web.processors.ProcessorProvider;
import com.jlectra.web.processors.ProcessorsModule;
import com.jlectra.core.url.UrlModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ANER0310, 2/9/13
 */
public class JLectraModule extends AbstractModule {

	private final static Logger log = LoggerFactory.getLogger(JLectraModule.class);

	@Override
	protected void configure() {
		Properties props = new Properties();

		try {
			props.load(JLectraModule.class.getResourceAsStream("/jlectra.properties"));

			Names.bindProperties(binder(), props);
		} catch (IOException e) {
			log.warn("Unable to load properties. Properties injection will not be able", e);
		}

		install(new UrlModule());
		install(new ProcessorsModule());
		install(new BlocksModule());

		bind(Processor.class).toProvider(ProcessorProvider.class);
	}
}
