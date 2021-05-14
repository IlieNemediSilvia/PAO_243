package pao.unibuc;

import java.sql.SQLException;

public class Program {
    public static void main(String[] args) {
        try {
            new NoteFrame().setVisible(true);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
