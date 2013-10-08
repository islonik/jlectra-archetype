package com.jlectra.web.request.impl;

/**
 * @author ANER0310
 * @date 9/25/13
 */
public interface TypeConverter<T> {
	public T convert(Object obj);
}
