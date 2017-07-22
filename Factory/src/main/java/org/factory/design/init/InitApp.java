package org.factory.design.init;

import org.adapter.framework.contracts.InitFramework;
import org.factory.design.config.elements.FactoryConfig;
import org.factory.design.init.AppInitConfig;
import org.factory.design.loaders.FactoryClassLoader;

/*
 * @author Anish Singh
 * 
 * This Class will be used by Adapter Framework to Initialized this framework.
 * 
 */

public class InitApp implements InitFramework {

	private FactoryClassLoader loader = null;

	public void init() {
		AppInitConfig config = new AppInitConfig();
		config.initAppConfigs();
		FactoryConfig factoryConfig = config.getConfigurations();
		loader = new FactoryClassLoader();
		try {
			loader.loadClassfromPackage(factoryConfig.getComponentScan().getPackageName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		loader = null;
	}

}
