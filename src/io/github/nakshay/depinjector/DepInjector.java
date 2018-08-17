package io.github.nakshay.depinjector;

import java.util.HashMap;

public final class DepInjector implements Injector {

	HashMap<String, Object> map;

	public DepInjector(String xmlResource, Object caller) {

		map = new HashMap<String, Object>();
		initIOCContainer(xmlResource,caller);

	}

	private void initIOCContainer(String xmlResource,Object caller) {

		prepareObjectsFromXML(xmlResource);
		AnnotationProcessor processor = new AnnotationProcessor(caller);
		processor.processAnnotaion(map);
		processor.instantiateAnnotations(map);
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