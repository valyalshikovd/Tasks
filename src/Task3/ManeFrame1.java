package Task3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ManeFrame1 extends JFrame {
    private JPanel panelMane;
    private JButton findFileButton;
    private JButton POPButton;
    private JLabel queueL;

    private MyPriorityQueue queue = new MyPriorityQueue();

    public ManeFrame1() {
        this.setTitle("Task3");
        this.setContentPane(panelMane);

        this.setResizable(false); //блокируем размеры окна

        POPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    queueL.setText(queue.pop());
                }catch (Exception exception){
                    queueL.setText("Queue is void");
                }
            }
        });
        findFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    try {
                        queueL.setText("Queue is ready");
                        queue.clear();
                        Main.solution(queue, file);
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
