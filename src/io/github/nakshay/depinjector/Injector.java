package io.github.nakshay.depinjector;

public interface Injector {

    // Returns the object to be injected

     Object inject(String dependencyName);
     Object inject(String dependencyName, Class className);
}