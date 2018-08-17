package io.github.nakshay.test;

import io.github.nakshay.depinjector.DepInjector;
import io.github.nakshay.depinjector.Injector;
import io.github.nakshay.depinjector.annotations.Inject;

class Consumer  {
	
	@Inject
	 AnotherAnnotedClass annotedInstance;
	
	public void test() {
	
		// need to pass this reference to get information of all annoted fields
		
        Injector injector = new DepInjector("resources/config.xml",this);

        MyClass instance= (MyClass)injector.inject("myclass");

        instance.printMe();
        	
        AnnotedClass inst = (AnnotedClass)injector.inject("AnnotedClass");
        inst.printMessage();
        
        
        // works without getting explicit instance 
        
        annotedInstance.printMessage();
        
          
	}
	
    public static void main(String ar[])  throws Exception{
    	
    	new Consumer().test();
        
    
    }
}


