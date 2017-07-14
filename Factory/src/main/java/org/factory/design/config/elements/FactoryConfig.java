package org.factory.design.config.elements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "factoryConfig")
public class FactoryConfig {

	@XmlElement(name = "component-scan")
	private ComponentScan componentScan;

	public ComponentScan getComponentScan() {
		return componentScan;
	}

	public void setComponentScan(ComponentScan componentScan) {
		this.componentScan = componentScan;
	}

}
