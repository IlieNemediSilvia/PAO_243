package pao.unibuc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class NotePrinter implements Printable, ActionListener {
    private JFrame frame;
    private JComponent component;

    public NotePrinter(JFrame frame, JComponent component){
        this.frame = frame;
        this.component = component;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        if(job.printDialog()){
            try {
                job.print();
                frame.dispose();
            } catch (PrinterException printerException) {
                printerException.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       if(pageIndex > 0){
           return NO_SUCH_PAGE;
       }
       graphics.setClip(0, 0, (int)pageFormat.getImageableWidth(), (int)pageFormat.getImageableHeight());
       graphics.translate((int)pageFormat.getImageableX(), (int)pageFormat.getImageableY());
       component.setSize((int)pageFormat.getImageableWidth(), (int)pageFormat.getImageableHeight());
       component.printAll(graphics);
       return PAGE_EXISTS;
    }

    public static void print(DefaultListModel<Note> notes, JFrame parent){
        JFrame frame = new JFrame("Print notes");
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[]{1};
        gridBagLayout.rowWeights = new double[]{1};
        frame.setLayout(gridBagLayout);

        String html = "<html><body><table border =\"0\"><tr><th><b><Title</b></th></tr>";
        for(int i = 1; i< notes.size(); i++){
            Note note = notes.get(i);
            html += String.format("<tr><td valign =\"top\" nowrap>%s</td><td valign =\"top\" nowrap>%s</td> </tr>", note.getTitle(), note.getContent());
        }
        html +="</table></body></html>";
        JLabel label = new JLabel(html);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setVerticalTextPosition(JLabel.TOP);
        JScrollPane pane = new JScrollPane(label);
        pane.setPreferredSize(parent.getSize());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        frame.add(pane,gridBagConstraints);

        JButton button = new JButton("Print");
        button.addActionListener(new NotePrinter(frame, label));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridy = 1;
        frame.add(button, gridBagConstraints);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(parent.getLocation());
    }
}
