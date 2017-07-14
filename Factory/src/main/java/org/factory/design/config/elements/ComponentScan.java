package org.factory.design.config.elements;

import javax.xml.bind.annotation.XmlAttribute;

public class ComponentScan {

	@XmlAttribute(name = "package", required = true)
	private String packageName;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
