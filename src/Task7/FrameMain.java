package Task7;

import Task7.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FrameMain extends JFrame{
    private JPanel panel1;
    private JButton подходитЛиButton;
    private JButton добавитьИзФайлаButton;
    private JButton сохранитьВФайлButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private MyGraph graph;


    public FrameMain() {
        this.setTitle("Task3");
        this.setContentPane(panel1);

        this.setResizable(false); //блокируем размеры окна

        подходитЛиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    new Answer(graph.solution((Integer)(spinner1.getValue())));
                }catch (Exception exception){

                }
            }
        });
        добавитьИзФайлаButton.addActionListener(new ActionListener() {
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
        сохранитьВФайлButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File sourceFile = new File("buffer.txt");
                    File destinationFile = fileopen.getSelectedFile();

                    // Создаем объекты FileReader и BufferedReader для чтения файла
                    FileReader fr = null;
                    try {
                        fr = new FileReader(sourceFile);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    BufferedReader br = new BufferedReader(fr);

                    // Создаем объект FileWriter для записи в новый файл
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter(destinationFile);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    String line;
                    while (true) {
                        try {
                            if (!((line = br.readLine()) != null)) break;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        // Записываем строку в новый файл
                        try {
                            fw.write(line + "\n");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    // Закрываем потоки
                    try {
                        fw.close();
                        br.close();
                        fr.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
}
