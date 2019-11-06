package cn.extewind.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalSystem {

    private Map<String,Object> properties = new ConcurrentHashMap<>();

    public <T> T getProperty(String name,Class<T> type){
        return type.cast(properties.get(name));
    }

    public void setProperty(String name,Object value){
        properties.put(name,value);
    }

    public void remove(String name){
        properties.remove(name);
    }
}
