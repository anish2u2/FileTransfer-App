package org.factory.design.context;

import java.util.HashMap;
import java.util.Map;

import org.factory.design.contracts.Context;
import org.springframework.stereotype.Component;

@Component("factoryContext")
public class AppContext implements Context {
	
	private Map<Object, Object> context;

	private static Context appContext;

	private AppContext() {
		context = new HashMap<Object, Object>();
	}

	public static Context createInstance() {
		if (appContext == null)
			appContext = new AppContext();
		return appContext;
	}

	public void add(Object object) {

	}

	public void destroy() {
		context.clear();
		context = null;
	}

	public Object get(String key) {
		return context.get(key);
	}

	public Object[] get() {
		return context.entrySet().toArray();
	}

	public Object getObject(Object object) {
		return context.get(object);
	}

	public void add(String key, Object object) {
		context.put(key, object);

	}

}
