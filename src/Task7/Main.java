package Task7;


import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.view.Viewer;

import java.io.*;

public class Main {
    private static Viewer viewer;

    public static void main(String[] args) {

        new FrameMain();


    }

    public static void visualization(){
        if (viewer != null) {
            viewer.close();
        }
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Test graph");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("buffer.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(" ");
                if (data.length == 1) {
                    try{
                        System.out.println(data[0]);
                        graph.addNode(data[0]);


                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    graph.getNode(data[0]).setAttribute("ui.label", "NODE " + data[0]);
                }
                if (data.length == 4) {
                    if(graph.getEdge(data[2] + data[0]) == null && graph.getEdge(data[0] + data[2]) == null){
                        graph.addEdge(data[0] + data[2],  data[0], data[2]);
                    }
                }
                line = reader.readLine();
            }
            graph.setAttribute("ui.stylesheet", "node { text-size: 50px; text-color: red; }");
            viewer = graph.display();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

