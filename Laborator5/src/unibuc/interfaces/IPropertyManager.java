package unibuc.interfaces;

import java.util.Map;

public interface IPropertyManager {
    Map<String, Object> getProperties();
    default void setProperty(String name, Object value){
        getProperties().put(name, value);
    }
    default Object getProperty(String name){
        return getProperties().get(name);
    }
}
