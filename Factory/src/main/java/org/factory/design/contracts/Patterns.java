package org.factory.design.contracts;

import org.factory.design.annotations.Components;

public interface Patterns {

	public Factory getDesignPatternFactory(Class<?> typeObject, Components.DesignType designType);

}
