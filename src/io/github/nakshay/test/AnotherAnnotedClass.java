package io.github.nakshay.test;

import io.github.nakshay.depinjector.annotations.Instance;

@Instance
public class AnotherAnnotedClass {

	public void printMessage() {
		System.out.println("This message is from another annoted class");
	}
}
