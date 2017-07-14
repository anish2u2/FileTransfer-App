package org.factory.design.impl.creational;

import java.util.Set;
import java.util.regex.Pattern;

import org.factory.design.abstracts.patterns.creational.AbstractFactoryPattern;
import org.factory.design.config.elements.FactoryConfig;
import org.factory.design.contracts.Context;
import org.factory.design.utility.AppConstant;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component("factoryPattern")
public class FactoryPatternImpl extends AbstractFactoryPattern {

	private Context context;

	public FactoryPatternImpl() {
		factory = this;
	}

	public static void createInstance() {
		if (factory == null)
			factory = new FactoryPatternImpl();
	}

	public void initFactory(Context appContext) {

	}

	public void destroyContext() {
		context.destroy();
		context = null;
	}

	@Override
	protected Object initObject(Class<?> classTypeObject) {

		return null;
	}

	public Class<?>[] getAllComposingComponentClasses(Class<?> composingClass) {
		try {
			final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
					false);
			provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));
			String packageName = ((FactoryConfig) context.get(AppConstant.APP_CONFIG)).getComponentScan()
					.getPackageName();
			final Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents(packageName);
			for (BeanDefinition bean : beanDefinitions) {
				Class<?> clazz = Class.forName(bean.getBeanClassName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		destroyContext();
		super.finalize();
	}

}
