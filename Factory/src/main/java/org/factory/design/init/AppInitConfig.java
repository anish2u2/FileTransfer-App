package org.factory.design.init;

import org.factory.design.annotations.Component;
import org.factory.design.config.XMLFileHandler;
import org.factory.design.config.elements.FactoryConfig;
import org.factory.design.utility.AppConstant;

/*
 * @author Anish Singh
 * 
 * This file will listen for application context refresh and init the application utility configs. 
 * 
 */

@Component(name = "initAppListener")
public class AppInitConfig {

	private FactoryConfig config = null;

	public void initAppConfigs() {
		config = (FactoryConfig) XMLFileHandler.unmarshal(AppConstant.FACTORY_CONFIG_FILE, FactoryConfig.class);

	}

	public FactoryConfig getConfigurations() {
		return config;
	}
}
