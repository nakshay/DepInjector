package io.github.nakshay.test;

import io.github.nakshay.depinjector.annotations.Instance;

@Instance
public class AnnotedClass {
	public void printMessage() {
		System.out.println("This is message from annoted class");
	}
}