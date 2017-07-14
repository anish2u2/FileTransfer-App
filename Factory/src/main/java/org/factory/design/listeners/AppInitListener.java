package org.factory.design.listeners;

import org.factory.design.config.XMLFileHandler;
import org.factory.design.config.elements.FactoryConfig;
import org.factory.design.contracts.Context;
import org.factory.design.utility.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/*
 * @author Anish Singh
 * 
 * This file will listen for application context refresh and init the application utility configs. 
 * 
 */

@Component("initAppListener")
public class AppInitListener {

	@Autowired
	@Qualifier("factoryContext")
	private Context context;

	@EventListener(classes = { ContextRefreshedEvent.class })
	public void initAppConfigs() {
		FactoryConfig config = (FactoryConfig) XMLFileHandler.unmarshal(AppConstant.FACTORY_CONFIG_FILE,
				FactoryConfig.class);
		context.add(AppConstant.APP_CONFIG, config);
	}
}
