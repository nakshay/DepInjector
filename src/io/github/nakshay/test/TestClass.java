package io.github.nakshay.test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.github.nakshay.depinjector.DepInjector;
import io.github.nakshay.depinjector.Injector;
import io.github.nakshay.depinjector.annotations.Inject;
public class TestClass {

	Injector injector;

	@Inject
	AnotherAnnotedClass annotedInstance;

	public TestClass() {
		// TODO Auto-generated constructor stub
	}

	@Before
	public void init() {
		injector = new DepInjector("resources/config.xml", this);

	}

	@After
	public void tearDown() {
		injector = null;
	}

	@Test
	public void testByFactory() {

		MyClass instance = (MyClass) injector.inject("myclass");
		assertTrue(instance instanceof MyClass && instance != null);

		// print message
		instance.printMe();
	}

	@Test
	public void testByFactoryAnnotation() {

		AnnotedClass inst = (AnnotedClass) injector.inject("AnnotedClass");
		assertTrue(inst instanceof AnnotedClass && inst != null);

		// print message
		inst.printMessage();

	}

	@Test
	public void testByOnlyAnnotation() {
		assertTrue(annotedInstance instanceof AnotherAnnotedClass && annotedInstance != null);

		// print message
		annotedInstance.printMessage();

	}

}
