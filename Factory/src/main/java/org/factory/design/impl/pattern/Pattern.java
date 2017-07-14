package org.factory.design.impl.pattern;

import org.factory.design.abstracts.AbstractPatterns;
import org.factory.design.contracts.Factory;
import org.springframework.stereotype.Component;

@Component("pattern")
public class Pattern extends AbstractPatterns {

	@Override
	protected Factory createFactoryObject(Class<?> typeOfObject, Class<?> factoryClass) {
			
		return null;
	}

}
