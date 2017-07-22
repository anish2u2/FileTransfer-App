package org.factory.design.context;

import java.util.HashMap;
import java.util.Map;

import org.factory.design.contracts.Context;
import org.springframework.context.annotation.Bean;

/*
 *@author Anish Singh
 *
 * This class will be used as a context for the current flow(i.e for current thread).
 * 
 * further release we will make it for current thread.  
 */

public class AppContext implements Context {

	private Map<Object, Object> context;

	private static Context appContext;

	private AppContext() {
		context = new HashMap<Object, Object>();
	}

	@Bean(name = "factoryContext")
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
