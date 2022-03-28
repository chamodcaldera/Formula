import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class jtable2 extends JFrame {
  private JFrame f2 = new JFrame("Second");

  private TableRowSorter sorter;










  jtable2(DefaultTableModel defaultTableModel1) {


    JFrame f1 = new JFrame();


    JTable table1 = new JTable(defaultTableModel1);
    sorter = new TableRowSorter<>(defaultTableModel1);
    table1.setRowSorter(sorter);
    table1.setBounds(0, 0, 1200, 450);

    JScrollPane scrollableArea = new JScrollPane(table1);
    scrollableArea.setBounds(0, 0, 1200, 600);

    JPanel panel=new JPanel();
    panel.setBounds(0,600,400,200);

    JTextField textField = new JTextField(15);
    JButton searchBtn = new JButton("Search");



    textField.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        search(textField.getText());
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        search(textField.getText());
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        search(textField.getText());
      }
      public void search(String str) {
        if (str.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          sorter.setRowFilter(RowFilter.regexFilter(str));
        }
      }
    });

    panel.add(textField); panel.add(searchBtn);

    f1.add(panel);
    f1.setSize(1600, 1200);
    f1.setLayout(null);
    f1.add(scrollableArea);
    f1.setVisible(true);

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
        table1.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();


        int columnIndexToSort = 0;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));


        sorter.setSortKeys(sortKeys);
        sorter.sort();





  }






}




















