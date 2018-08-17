# DepInjector
:fire:Simple dependency injection framework in java :fire:

This framework is inspired from Spring core framework https://github.com/spring-projects/spring-framework and uses Java Reflection API.


work in progress! 

API may change in future.


# What is working?

1. Creating instance via Injector#inject('id'), fully qualified class name must be present in config file 

Ex.

`Injector injector = new DepInjector("resources/config.xml");`

`MyClass instance= (MyClass)injector.inject("myclass");`


2. Creating instance by using @Instance Annotation and getting the object via  Injector#inject('id'),
here id must be equal to ClassName (case sensitve), assigning short id is work in progress 
 
Ex.

`AnnotedClass inst = (AnnotedClass)injector.inject("AnnotedClass");`

`inst.printMessage();`


3. Object instantiation via Annotation 

Ex.

`@Inject`

`AnotherAnnotedClass annotedInstance;`

`annotedInstance.printMessage();`

	 
  
    
# To be done.


1. getting instance by passing class type to inject method to remove parsing step.(not a priority currently)

`injector.inject("myclass", MyClass.class);`


# Dependencies 

https://github.com/ronmamo/reflections
 
 
     
P.S. Pull request is appreciated  


