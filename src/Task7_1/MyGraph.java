package Task7_1;

import Task2.MyLinkedList;
import Task3.MyQueue;

import java.io.*;
import java.util.*;

public class MyGraph {
    public HashMap<String, Node> nodes;

    public MyGraph() {
        this.nodes = new HashMap<>();
    }

    public Node get(String name) {
        return nodes.get(name);
    }

    public void add(String name) {
        if (!nodes.containsKey(name)) {
            nodes.put(name, new Node(name));
        }
    }

    public void addRibOriented(String name, String destinationNodeName, int weight) {
        this.get(name).ribs.add(new Rib(weight, new Node(destinationNodeName)));
    }

    public void addRib(String name, String destinationNodeName, int weight) {
        this.get(name).ribs.add(new Rib(weight, this.get(destinationNodeName)));
        System.out.println(this.get(destinationNodeName));
        this.get(destinationNodeName).ribs.add(new Rib(weight, this.get(name)));
    }

    public void remove(String name) {
        for (Map.Entry<String, Node> nodeEntry : nodes.entrySet()) {
            for (Rib rib : nodeEntry.getValue().ribs) {
                if (rib.destinationNode.name == name) {
                    rib = null;
                }
            }
        }
        nodes.remove(name);
    }

    public void read(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                readingString(line);
                line = reader.readLine();
            }
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

    private void readingString(String line) {
        String[] resArr = line.split(" ");
        if (resArr.length == 1) {
            this.add(resArr[0]);
        }
        if (resArr.length == 5) {
            if (resArr[4] == "+") {
                this.addRibOriented(resArr[0], resArr[2], Integer.parseInt(resArr[3]));
            } else {
                System.out.println(resArr[0] + resArr[2] + Integer.parseInt(resArr[3]));
                this.addRib(resArr[0], resArr[2], Integer.parseInt(resArr[3]));
            }
        }
    }

    public void writingToConsole() {
        for (Map.Entry<String, Node> nodeEntry : nodes.entrySet()) {
            System.out.println(nodeEntry.getValue().name);
            for (Rib rib : nodeEntry.getValue().ribs) {
                System.out.println(nodeEntry.getValue().name + " -- " + rib.destinationNode.name + " " + rib.weight);
            }
        }
    }

    public void writeToFile() throws IOException {
        File file = new File("buffer.txt");
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (Map.Entry<String, Node> nodeEntry : nodes.entrySet()) {
            pw.println(nodeEntry.getValue().name);
        }
        for (Map.Entry<String, Node> nodeEntry : nodes.entrySet()) {
            for (Rib rib : nodeEntry.getValue().ribs) {
                pw.println(nodeEntry.getValue().name + " -- " + rib.destinationNode.name + " " + rib.weight);
            }
        }
        pw.close();
        bw.close();
        fw.close();


    }

    public MyLinkedList<String> solution(int n) {
        MyLinkedList<String> res = new MyLinkedList<>();
        for (Map.Entry<String, Node> nodeEntry : nodes.entrySet()) {
            boolean flag = true;
            for (Map.Entry<String, Node> nodeEntry2 : nodes.entrySet()) {
                if(search(nodeEntry.getValue(), nodeEntry2.getValue()) - 1 >= n){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(nodeEntry.getKey());
            }
        }
        return res;
    }

    private int search(Node node, Node nodeDestination) {
        MyQueue<String> queue = new MyQueue<>();
        MyLinkedList<String> list = new MyLinkedList<>();
        MyLinkedList<String> listBeg = new MyLinkedList<>();
        for (Rib rib : node.ribs) {
            queue.add(rib.destinationNode.name);
            list.add(rib.destinationNode.name);
            listBeg.add(rib.destinationNode.name);
        }
        boolean flag = false;
        int counter = 0;
        while (!flag) {
            System.out.print(" :LA");
            queue.write();

            counter++;
            flag = cicle(queue, nodeDestination);;
            if (!flag) {
                MyLinkedList<String> tmp = new MyLinkedList<>();
                for (String nod : list) {
                    for (Rib rib : this.get(nod).ribs) {
                        if(!cntns(listBeg, rib.destinationNode)){
                            tmp.add(rib.destinationNode.name);
                            queue.add(rib.destinationNode.name);
                            listBeg.add(rib.destinationNode.name);
                        }
                    }
                }
                list = tmp;
            }
        }
        return counter;
    }


    private boolean cicle(MyQueue<String> queue, Node node) {
        while (!queue.isEmpty()) {
            if (Objects.equals(this.get(queue.remove()).name, node.name)) {
                return true;
            }
        }
        return false;
    }
    private boolean cntns(MyLinkedList<String> lst, Node node){
        for (String ndn : lst) {
            if(Objects.equals(ndn, node.name)){
                return true;
            }
        }
        return false;
    }

}
