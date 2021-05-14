package pao.unibuc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

import static pao.unibuc.NotePanel.NEW_NOTE;

public class NoteFrame extends JFrame {
    public NoteFrame() throws SQLException {
        Service service = new Service();
        setTitle("Notes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        final DefaultListModel<Note> notes = new DefaultListModel<>();
        JList<Note> list = new JList<>(notes);
        splitPane.setLeftComponent(list);
        JPanel panel = new JPanel();
        splitPane.setRightComponent(panel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[]{1};
        gridBagLayout.rowWeights = new double[]{1, 0};
        panel.setLayout(gridBagLayout);
        final NotePanel notePanel = new NotePanel();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0,0,5, 0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        panel.add(notePanel, gridBagConstraints);
        notePanel.setVisible(false);
        JPanel buttonsPanel = new JPanel();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        panel.add(buttonsPanel, gridBagConstraints);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(event -> {
            Note note = notePanel.getNote();
            if(!note.getTitle().isEmpty() && !note.getContent().isEmpty()){
                try {
                    note = service.createNote(note.getTitle(), note.getContent());
                    notes.addElement(note);
                    list.setSelectedIndex(notes.size() - 1);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(NoteFrame.this,
                            exception.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonsPanel.add(createButton);
        createButton.setVisible(false);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(event-> {
            Note note = notePanel.getNote();
            if(!note.getTitle().isEmpty() && !note.getContent().isEmpty()){
                try {
                    if(service.updateNote(note)){
                        notes.set(list.getSelectedIndex(), note);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(NoteFrame.this,
                            exception.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonsPanel.add(updateButton);
        updateButton.setVisible(false);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event->{
            try {
                if(service.deleteNote(notePanel.getNote().getId())){
                    int index = list.getSelectedIndex();
                    list.setSelectedIndex(0);
                    notes.remove(index);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(NoteFrame.this,
                        exception.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonsPanel.add(deleteButton);
        deleteButton.setVisible(false);

        JButton printButton = new JButton("Print");
        printButton.addActionListener(event->{
            NotePrinter.print(notes, NoteFrame.this);
        });
        buttonsPanel.add(printButton);
        printButton.setVisible(false);

        notes.addElement(new Note().title(NEW_NOTE));
        list.addListSelectionListener(event->{
            notePanel.setVisible(true);
            Note note = ((JList<Note>)event.getSource()).getSelectedValue();
            notePanel.setNote(note);
            createButton.setVisible(NEW_NOTE.equals(note.getTitle()));
            updateButton.setVisible(!NEW_NOTE.equals(note.getTitle()));
            deleteButton.setVisible(!NEW_NOTE.equals(note.getTitle()));
            printButton.setVisible(notes.getSize() > 1);
        });

        try {
            service.readNotes().forEach(note -> notes.addElement(note));
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(NoteFrame.this,
                    exception.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)(dimension.getWidth()-getWidth())/2, (int)(dimension.getHeight()-getHeight())/2);
    }
}
