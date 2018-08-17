package io.github.nakshay.depinjector;

import java.util.HashMap;

public final class DepInjector implements Injector {

	HashMap<String, Object> map;

	public DepInjector(String xmlResource) {

		map = new HashMap<String, Object>();

		initIOCContainer(xmlResource);

	}

	private void initIOCContainer(String xmlResource) {

		prepareObjectsFromXML(xmlResource);
		AnnotationProcessor processor = new AnnotationProcessor();
		processor.processAnnotaion(map);
	}

	@Override
	public Object inject(String dependencyName) {
		try {
			return Class.forName(map.get(dependencyName).toString()).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Object inject(String dependencyName, Class className) {

		return null;
	}

	private void prepareObjectsFromXML(String xmlResource) {
		ConfigurationReader.readConfig(xmlResource, map);
	}
}