package pao.unibuc;

import java.io.Serializable;
import java.util.UUID;

public class Note implements Serializable {
    private String id;
    private String title;
    private String content;

    public Note(){
        id = UUID.randomUUID().toString();
    }
    public Note id(String id){
        this.id = id;
        return this;
    }
    public Note title(String title){
        this.title = title;
        return this;
    }
    public Note content(String content){
        this.content = content;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return title;
    }
}
