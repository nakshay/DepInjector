package io.github.nakshay.depinjector;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import io.github.nakshay.depinjector.annotations.Instance;

final public class AnnotationProcessor {

	void processAnnotaion(Map<String, Object> map) {
		prepareClassFactory(map);
	}

	
	//create map of class key and class names
	private void prepareClassFactory(Map<String, Object> map) {

		Reflections reflections = prepareReflection();
		Set<Class<?>> classNames = reflections.getTypesAnnotatedWith(Instance.class);

		for (Class<?> cls : classNames) {
			String name = cls.toString();
			name = name.substring(name.indexOf(' ') + 1, name.length());
			map.put(name.substring(name.lastIndexOf('.') + 1, name.length()), name);
		}
	}
	
	
	
	// returns Reflection instance to scan annotation
	//This creates copy of loaders twice, rework required

	private Reflections prepareReflection() {

		ArrayList<URL> urls = new ArrayList<URL>();
		ClassLoader[] classloaders = { getClass().getClassLoader(), Thread.currentThread().getContextClassLoader() };

		for (int i = 0; i < classloaders.length; i++) {
			if (classloaders[i] instanceof URLClassLoader) {
				urls.addAll(Arrays.asList(((URLClassLoader) classloaders[i]).getURLs()));

			} else {
				throw new RuntimeException("classLoader is not an instanceof URLClassLoader");
			}
		}
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setUrls(urls);

		return new Reflections(configurationBuilder);
	}

}
