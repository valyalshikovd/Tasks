package Task8;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MyFrame extends JFrame{
    private JPanel panel1;
    private JButton добавитьФайлButton;
    private JButton ПРОВЕРИТButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private MyGraph graph;


    public MyFrame() {
        this.setTitle("Task8");
        this.setContentPane(panel1);

        this.setResizable(false); //блокируем размеры окна

        ПРОВЕРИТButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    new Answer(graph.solution((Integer)(spinner1.getValue()), (Integer)(spinner2.getValue())));
                }catch (Exception exception){

                }
            }
        });
        добавитьФайлButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter fw = null;
                try {
                    fw = new FileWriter("buffer.txt", false);
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    graph = new MyGraph();
                    graph.read(file.getName());
                    try {
                        graph.writeToFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    Main.visualization();
                }
            }
        });
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
}

