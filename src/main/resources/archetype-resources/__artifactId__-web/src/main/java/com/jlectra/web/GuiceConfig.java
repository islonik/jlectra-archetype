package com.jlectra.web;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author ANER0310, 2/9/13
 */
public class GuiceConfig extends GuiceServletContextListener{
	static Collection<AbstractModule> modules = new ArrayList<AbstractModule>(){{
		add(new ServletModule(){
			@Override
			protected void configureServlets() {
				super.configureServlets();

				install(new JLectraModule());
				install(new JpaPersistModule("JlectraCoreUnit"));

				filter("*").through(PersistFilter.class);

				/*serve("/__api__*//*").with(GuiceContainer.class, new HashMap<String, String>(){{
					put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE.toString());
				}});

				serve("/_engine*//*").with(GuiceContainer.class, new HashMap<String, String>(){{
					put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE.toString());
				}});*/

				serveRegex("^((?!^/static/.+$).)*$").with(JLectra.class);
			}
		});
	}};

	public GuiceConfig() {
		super();
		PropertyConfigurator.configure(GuiceConfig.class.getResourceAsStream("/log.properties"));
	}

	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(modules);
		GuiceHolder.set(injector);

		return injector;
	}
}
