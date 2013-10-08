package com.jlectra.web;

import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ANER0310
 *         Date: 9/25/13
 */
public class GuiceHolder {
	private static final Logger log = LoggerFactory.getLogger(GuiceHolder.class);

	private static Injector injector;

	private static final CountDownLatch latch = new CountDownLatch(1);
	private static final AtomicBoolean isSet = new AtomicBoolean(false);


	public static Injector get(){
		try {
			latch.await();
		} catch (InterruptedException e) {
			log.warn("Injector initialization was interrupted!", e);
		}

		return injector;
	}

	public static void set(Injector injector){
		if(!isSet.get() && isSet.compareAndSet(false, true)){
			GuiceHolder.injector = injector;
			latch.countDown();
		}
	}
}