package io.github.nakshay.test;

import io.github.nakshay.depinjector.DepInjector;
import io.github.nakshay.depinjector.Injector;
import io.github.nakshay.depinjector.annotations.Inject;
import io.github.nakshay.depinjector.annotations.Instance;

class Consumer  {
	
	@Inject
	AnnotedClass myclass;
	
    public static void main(String ar[])  throws Exception{

        Injector injector = new DepInjector("resources/config.xml");

        MyClass instance= (MyClass)injector.inject("myclass");

        instance.printMe();

        // return already casted object 
        // to be done 

        // MyClass instance2= injector.inject("myclass",MyClass.class);
        // instance2.printMe();
     
        
    
    }
}

@Instance
class AnnotedClass {
	public void printMessage() {
		System.out.println("This is message from annoted class");
	}
}


@Instance
class AnotherAnnotatedClass {
	public void printMessage() {
		System.out.println("This is message from another annoted class");
	}
}