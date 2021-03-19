package unibuc.interfaces;

import java.util.HashMap;
import java.util.Map;

public abstract class Configuration implements IConfiguration{
    private String path;
    private Map<String, Object> properties;

    public Configuration(String path){
        this.path = path;
        this.properties = new HashMap<String, Object>();
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }
    @Override
    public String getPath() {
        return path;
    }
}
