package pao.unibuc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//http://db.apache.org/derby/derby_downloads.html

public class Service implements AutoCloseable{
    private Connection connection;

    public Service() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:derby:notesDB;create=true");
        boolean notFound = true;

        ResultSet results = connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
        while(results.next()){
            if("notes".equalsIgnoreCase(results.getString("TABLE_NAME"))){
                notFound = false;
                break;
            }
        }

        if(notFound){
            connection.createStatement()
                    .execute("CREATE TABLE notes (id char(36) primary key, title varchar(50), content varchar(200))");
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    public Note createNote(String title, String content) throws Exception {
        Note note = new Note().title(title).content(content);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO notes (id, title, content) VALUES (?,?,?)");
        statement.setString(1, note.getId());
        statement.setString(2, note.getTitle());
        statement.setString(3, note.getContent());
        if(statement.executeUpdate() == 1){
            return note;
        }
        return null;
    }


    public List<Note> readNotes() throws Exception {
        List<Note> notes = new ArrayList<>();
        ResultSet results = connection.createStatement().executeQuery("SELECT id, title, content FROM notes");
        while(results.next()){
            notes.add(new Note().id(results.getString(1))
            .title(results.getString(2))
            .content(results.getString(3)));
        }
        return notes;
    }

    public boolean updateNote(Note note) throws Exception {
        PreparedStatement statement = connection.prepareStatement("UPDATE notes SET title = ?, content = ? WHERE id = ?");
        statement.setString(1, note.getTitle());
        statement.setString(2, note.getContent());
        statement.setString(3, note.getId());
        return statement.executeUpdate() == 1;
    }

    public boolean deleteNote(String id) throws Exception {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM notes WHERE id = ?");
        statement.setString(1, id);
        return statement.executeUpdate() == 1;
    }
}
