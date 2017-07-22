package org.factory.design.reflection;

import java.util.List;

import org.factory.design.annotations.Component;
import org.factory.design.annotations.Components.DesignType;
import org.factory.design.annotations.Inject;
import org.factory.design.contracts.Factory;
import org.factory.design.contracts.Patterns;
import org.factory.design.utility.reflect.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component(name = "objectCreator")
public class ObjectCreator {

	@Inject(qualifier = "pattern")
	private Patterns pattern;

	public void initAppObjectCreation() {
		//List<Class<?>> listOfInjectableClasses = Util.findAllInjectableClasses();
		Factory factory = pattern.getDesignPatternFactory(DesignType.CREATIONAL);

	}

}
