package com.jlectra.web.tpl.impl;

import com.jlectra.web.tpl.TplEngine;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ANER0310
 *         Date: 2/12/13
 *         Time: 2:51 PM
 */
@Singleton
public class VelocityEngine implements TplEngine<VelocityEngine> {
	private static final Logger log = LoggerFactory.getLogger(VelocityEngine.class);

	private boolean ready = false;

	@Override
	public void init() {

		try {
			Properties props = new Properties();
			props.load(VelocityEngine.class.getResourceAsStream("/velocity.properties"));
			Velocity.init(props);
		} catch (IOException e) {
			log.error("Unable to read velocity.properties, velocity will be initialized with default configuration", e);
			Velocity.setProperty(RuntimeConstants.RUNTIME_LOG, "logs/velocity.log");
			Velocity.setProperty(RuntimeConstants.INPUT_ENCODING, "UTF-8");
			Velocity.setProperty(RuntimeConstants.OUTPUT_ENCODING, "UTF-8");
			Velocity.init();
		}

		ready = true;
	}

	@Override
	public boolean isInitialized() {
		return ready;
	}

	@Override
	public VelocityEngine getEngine() {
		throw new UnsupportedOperationException("Multiple instances of Velocity isn't supported");
	}
}