# DepInjector
Simple Framework of Dependency Injection System in Java.
This framework is inspired from Spring core framework https://github.com/spring-projects/spring-framework


work in progress! 

API may change in future.


# What is working?

1.Creating instance via Injector#inject('id'), fully qualified class name must be present in config file 
2. direct instantiating members via @Inject annotation


Ex.

`Injector injector = new DepInjector("resources/config.xml");`
`MyClass instance= (MyClass)injector.inject("myclass");`


2. Creating instance by using @Instance Annotation and getting the object via  Injector#inject('id'),
here id must be equal to ClassName (case sensitve), assigning short id is work in progress 
 
 Ex.

`AnnotedClass inst = (AnnotedClass)injector.inject("AnnotedClass");`
	`inst.printMessage();`
    
    
# To be done.


1. getting instance by passing class type to inject method to remove parsing step.(not a priority currently)

`injector.inject("myclass", MyClass.class);`

 
     
#Pull request is appreciated   


