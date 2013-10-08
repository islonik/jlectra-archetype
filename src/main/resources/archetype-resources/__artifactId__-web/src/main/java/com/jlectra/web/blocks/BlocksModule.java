package com.jlectra.web.blocks;

import com.google.inject.AbstractModule;
import com.jlectra.web.blocks.impl.StaticBlock;

/**
 * @author ANER0310
 * @date 9/27/13
 */
public class BlocksModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Block.class)
				.annotatedWith(Static.class)
				.to(StaticBlock.class);
	}
}
