package io.github.nakshay.depinjector;

import java.util.HashMap;
import java.util.Map;


public class DepInjector implements Injector {

    HashMap<String, Object> map ;
    public DepInjector(String xmlResource){
        map = new HashMap<String, Object>();
        prepareObjects(xmlResource);
       
    }
    
    @Override
    public Object inject(String dependencyName){
        try{
            return Class.forName(map.get(dependencyName).toString()).newInstance();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Object inject(String dependencyName, Class className) {


    return null;
    }
    public void prepareObjects(String xmlResource){
        ConfigurationReader.readConfig(xmlResource,map);
    }
}