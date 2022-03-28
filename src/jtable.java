import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class jtable {
    static Formula1ChampionshipManager fManager1 = new  Formula1ChampionshipManager();



    jtable(DefaultTableModel defaultTableModel)  {              //jtable constructor



        JFrame f =new JFrame("Formula1 Championship ");


        JTable table = new JTable(defaultTableModel);
        table.setBounds(0,0,900,450);

        JScrollPane scrollableArea = new JScrollPane(table);
        scrollableArea.setBounds(0,0,900,600);







        JPanel panel=new JPanel();
        panel.setBounds(0,600,400,200);

           JButton b2=new JButton("Points Ascending oder");
        b2.setBounds(50,400,80,30);
        b2.setBackground(Color.green);


        JButton b3=new JButton("Sort 1st Pos into Descending");
        b3.setBounds(50,400,80,30);
        b3.setBackground(Color.yellow);

        JButton b4=new JButton("Generate Race");
        b4.setBounds(50,400,80,30);
        b4.setBackground(Color.yellow);

        JButton b5=new JButton("Display Race details");
        b5.setBounds(50,400,80,30);
        b5.setBackground(Color.yellow);

         panel.add(b2); panel.add(b3); panel.add(b4);panel.add(b5);
        f.add(panel);





        f.setSize(900,750);
        f.setLayout(null);
        f.add(scrollableArea);

        f.setVisible(true);




        b2.addActionListener(new ActionListener() {             //clicked action for b2 button
            @Override
            public void actionPerformed(ActionEvent e) {


                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();


                int columnIndexToSort = 7;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));


                sorter.setSortKeys(sortKeys);
                sorter.sort();






            }
        });



        b3.addActionListener(new ActionListener() {             //clicked action for b3 button
            @Override
            public void actionPerformed(ActionEvent e) {



                TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();


                int columnIndexToSort = 4;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));


                sorter.setSortKeys(sortKeys);
                sorter.sort();



            }
        });


        b4.addActionListener(new ActionListener() {                 //clicked action for b4 button
            @Override
            public void actionPerformed(ActionEvent e) {


                fManager1.generateRace();

                f.setVisible(false);                //Close existing window

                Collections.sort(fManager1.formula1Drivers);                    //Displaying driver table again
                String[] header = {"Driver Name", "Driver Location", "Driver Age", "Driver Team", "First Places", "Second Places", "Third Places", "Points", "Num of Races"};

                DefaultTableModel model = new DefaultTableModel(header,0);

                for (int i = 0; i < fManager1.formula1Drivers.size(); i++) {
                    model.addRow( new Object[]{ fManager1.formula1Drivers.get(i).getName(),fManager1.formula1Drivers.get(i).getLocation(),fManager1.formula1Drivers.get(i).getAge(), fManager1.formula1Drivers.get(i).getTeam(),
                            fManager1.formula1Drivers.get(i).getNumOfFirstPos(), fManager1.formula1Drivers.get(i).getNumOfSecondPos(), fManager1.formula1Drivers.get(i).getNumOfThirdPos(), fManager1.formula1Drivers.get(i).getNumOfPoints(),fManager1.formula1Drivers.get(i).getNumOfRaces()} );
                }

                new jtable(model);





            }
        });



        b5.addActionListener(new ActionListener() {                 //clicked action for b5 button
            @Override
            public void actionPerformed(ActionEvent e) {



                fManager1.createTableModel();



//

            }
        });







}


}



