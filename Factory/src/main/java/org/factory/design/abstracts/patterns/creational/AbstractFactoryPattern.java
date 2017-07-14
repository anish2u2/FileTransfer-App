package org.factory.design.abstracts.patterns.creational;

import java.lang.reflect.Type;

import org.factory.design.contracts.Factory;
import org.factory.design.contracts.patterns.creational.FactoryPattern;
import org.factory.design.impl.creational.FactoryPatternImpl;

public abstract class AbstractFactoryPattern implements FactoryPattern {

	protected static Factory factory;

	protected abstract Object initObject(Class<?> classTypeObject);

	public static class ObjectCreator<T> implements Creator<T> {

		public ObjectCreator() {
			if (factory == null)
				FactoryPatternImpl.createInstance();
		}

		@SuppressWarnings("unchecked")
		public T createObject() {
			Type genericType = this.getClass().getGenericSuperclass();
			return (T) ((CompositAbstractFactoryPattern) factory).initObject(genericType.getClass());
		}

	}

}
