package com.jlectra.web.processors;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.Map;

/**
 * @author ANER0310
 * @date 9/25/13
 */
@Singleton
public class ProcessorProvider implements Provider<Processor> {
	private final Map<String, Processor> processors;
	private final String mode;

	@Inject
	public ProcessorProvider(Map<String, Processor> processors,
							 @Named("jlectra.web.engine.mode")String mode)
	{
		this.processors = processors;
		this.mode = mode;
	}

	@Override
	public Processor get() {
		return processors.get(mode);
	}
}
