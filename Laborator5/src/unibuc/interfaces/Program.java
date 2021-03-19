package unibuc.interfaces;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws Exception {
        IConfiguration[] configurations = new IConfiguration[]{
                new DatabaseConfiguration("./resources/database.cfg"),
                new FolderConfiguration("./resources/folder.cfg")
        };
        for(IConfiguration configuration : configurations){
            System.out.println("===========");
            configuration.load();
            configuration.print();

            Map<String, Object> properties = new HashMap<>();
            properties.put("newKey", "newValue");
            configuration.update(properties);
            configuration.visit((key,value) -> System.out.println(String.format("key = %s, value = %s", key, value)));
//            configuration.visit(new IConfigurationVisitor() {
//                @Override
//                public void visit(String key, Object value) {
//                    System.out.println(String.format("key = %s, value = %s", key, value));
//                }
//            });

            configuration.store();
            configuration.load();
        }
    }
}
