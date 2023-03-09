package Task2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JButton посчитатьButton;
    private JPanel panel;

    public MyFrame(){
        this.setTitle("Сокобан");
        this.setResizable(false);
        this.setContentPane(panel);

        посчитатьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn();
            }
        });

        buildingModel(table1);
        buildingModel(table2);
        table1.setRowHeight(40);
        table1.setEnabled(true);
        table2.setRowHeight(40);
        table2.setEnabled(true);
        table3.setRowHeight(40);
        table3.setEnabled(false);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
    private void buildingModel(JTable table){
        try {
            Object[] names2 = {"", "", "", "", ""};
            DefaultTableModel mode2 = new DefaultTableModel(new String[][]{{"", "", "", "", ""}}, names2) {
                public Class getColumnClass(int column) {
                    return getValueAt(0, column).getClass();
                }
            };
            table.setModel(mode2);
        }catch (Exception ex){
            new Error();
        }
    }
    private void btn(){
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        for(int i = 0; i < 5; i++){
            list1.add(Integer.parseInt((String) table1.getValueAt(0, i)));
            list2.add(Integer.parseInt((String) table2.getValueAt(0, i)));
        }
        MyLinkedList<Integer> res =  MyLinkedList.solution(list1, list2);

        MyLinkedList.MyLinkedListNode tmp = res.getFirstElementh();
        Object[][] ress = new Object[1][10];
        int counter = 0;
        while (tmp!=null){
            if (counter == 10) {
                break;
            }
            ress[0][counter] = tmp.getValue();
            counter++;
            tmp = tmp.getNext();
        }
        try {
            Object[] names2 = {"", "", "", "", "", "", "", "", "", ""};
            DefaultTableModel mode2 = new DefaultTableModel(ress, names2) {
                public Class getColumnClass(int column) {
                    return getValueAt(0, column).getClass();
                }
            };
            table3.setModel(mode2);
        }catch (Exception ex){
            new Error();
        }
        System.out.println();
    }
}
