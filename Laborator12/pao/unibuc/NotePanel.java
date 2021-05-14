package pao.unibuc;

import javax.swing.*;
import java.awt.*;

public class NotePanel extends JPanel {

    public static final String NEW_NOTE = "<New note>";

    private JTextField titleTextField;
    private JTextPane contentTextPane;
    private Note note;

    public NotePanel(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{0, 1};
        gridBagLayout.columnWeights = new double[]{0,1};
        setLayout(gridBagLayout);
        add(new JLabel("Title"));
        titleTextField = new JTextField();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(titleTextField, gridBagConstraints);
        JLabel contentLabel = new JLabel("Content");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.gridy = 1;
        add(contentLabel, gridBagConstraints);
        contentTextPane = new JTextPane();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 1;
        add(contentTextPane, gridBagConstraints);
    }

    public void setNote(Note note) {
        this.note = new Note().id(note.getId()).title(note.getTitle()).content(note.getContent());
        titleTextField.setText(note.getTitle().equalsIgnoreCase(NEW_NOTE) ? "" : note.getTitle());
        contentTextPane.setText(note.getContent());
        titleTextField.requestFocus();
    }

    public Note getNote() {
        return note.title(titleTextField.getText()).content(contentTextPane.getText());
    }
}
