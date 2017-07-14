package org.factory.design.abstracts;

import java.lang.reflect.Type;

import org.factory.design.annotations.Components.DesignType;
import org.factory.design.contracts.Factory;
import org.factory.design.contracts.Patterns;
import org.factory.design.impl.creational.FactoryPatternImpl;
import org.springframework.stereotype.Component;

public abstract class AbstractPatterns implements Patterns {

	public Factory getDesignPatternFactory(Class typeObject, DesignType designType) {
		Factory factory=null;
		Type type=typeObject.getGenericSuperclass();
		
		if (DesignType.CREATIONAL == designType) {
			factory = new FactoryPatternImpl<>();
		}
		return createFactoryObject(typeObject, factory);
	}

	protected abstract Factory createFactoryObject(Class<?> typeOfObject, Factory factory);

}
