package pao.unibuc.clone;

import pao.unibuc.format.Formatter;

public class Cloner {
    public static<T> T clone(T object){
        return Formatter.deserialize(Formatter.serialize(object));
    }
}
