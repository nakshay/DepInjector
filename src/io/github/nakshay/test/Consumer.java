package io.github.nakshay.test;

import io.github.nakshay.depinjector.DepInjector;
import io.github.nakshay.depinjector.Injector;

class Consumer  {
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
