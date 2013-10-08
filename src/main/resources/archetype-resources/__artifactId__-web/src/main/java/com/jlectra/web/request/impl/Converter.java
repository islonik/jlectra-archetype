package com.jlectra.web.request.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ANER0310
 * @date 9/25/13
 */
public class Converter {
	private static final Map<Class, TypeConverter> converters = new HashMap<Class, TypeConverter>(){{
		put(String.class, new TypeConverter<String>(){
			@Override
			public String convert(Object obj) {
				return obj.toString();
			}
		});

		put(Integer.class, new TypeConverter<Integer>(){
			@Override
			public Integer convert(Object obj) {
				return Integer.valueOf(obj.toString());
			}
		});

		put(Collection.class, new TypeConverter<Collection>(){
			@Override
			public Collection convert(Object obj) {
				return Arrays.asList((Object[])obj);
			}
		});
	}};

	public <T> T convert(Object value, Class<T> type){
		return (T)converters.get(type).convert(value);
	}
}
