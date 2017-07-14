package org.factory.design.abstracts.patterns.creational;

import java.lang.reflect.Type;

import org.factory.design.contracts.Factory;
import org.factory.design.contracts.patterns.creational.AbstractFactoryPattern;
import org.factory.design.impl.creational.AbstractFactoryPatternImpl;

public abstract class CompositAbstractFactoryPattern implements AbstractFactoryPattern {

	protected static Factory factory;

	protected abstract Object initObject(Class<?> classTypeObject);

	public static class ObjectCreator<T> implements Creator<T> {

		public ObjectCreator() {
			if (factory == null)
				AbstractFactoryPatternImpl.createInstance();
		}

		@SuppressWarnings("unchecked")
		public T createObject() {
			Type genericType = this.getClass().getGenericSuperclass();
			return (T) ((CompositAbstractFactoryPattern) factory).initObject(genericType.getClass());
		}

	}

}
