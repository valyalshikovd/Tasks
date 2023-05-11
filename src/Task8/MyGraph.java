package Task8;

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
                if (Objects.equals(rib.destinationNode.name, name)) {
                    nodeEntry.getValue().ribs.remove(rib);
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

    public LinkedList<String> solution(int n, int k) {
        int counter = 0;
        List<String> ribs = new ArrayList<>();
        List<String> archribs = new ArrayList<>();
        LinkedList<String> res = new LinkedList<>();
        for (String nd: nodes.keySet()) {
            List<String> listDistant = new ArrayList<>();
            for (String ndd: nodes.keySet()) {
                dijkstraAlgorithm(get(nd), get(ndd));
                if(get(ndd).label > n) {
                    listDistant.add(ndd);
                }
                for (Node ns: nodes.values()) {
                    ns.label = 2147483646;
                }
            }
            listDistant.clear();
            if(counter < k + 1){
                ribs.addAll(addRibs(n, k, counter, archribs));
            }
            for (String ndd: nodes.keySet()) {
                dijkstraAlgorithm(get(nd), get(ndd));
                if(get(ndd).label > n){
                    listDistant.add(ndd);
                }
                for (Node ns: nodes.values()) {
                    ns.label = 2147483646;
                }
            }
            if(listDistant.size() == 0){

                res.add(nd);
                res.addAll(ribs);
                return res;
            }
            for (String str: ribs) {
                String[] arr = str.split("");
                for (Rib rib: this.get(arr[0]).ribs) {
                    if(Objects.equals(rib.destinationNode.name, arr[1])){
                        System.out.println("del_rib");
                        this.get(arr[0]).ribs.remove(rib);
                        break;
                    }
                }
                for (Rib rib: this.get(arr[1]).ribs) {
                    if(Objects.equals(rib.destinationNode.name, arr[0])){
                        this.get(arr[1]).ribs.remove(rib);
                        break;
                    }
                }
            }
            listDistant.clear();
            archribs.addAll(ribs);
            ribs.clear();
        }
        res.add("Нет таких узлов");
        return res;
    }
    private LinkedList<String> addRibs(int n, int k, int counter, List<String> ribs){
        LinkedList<String> res = new LinkedList<>();
        for (String nd: nodes.keySet()) {
            for (String ndd: nodes.keySet()) {
                dijkstraAlgorithm(get(nd), get(ndd));
                if(get(ndd).label > n && get(ndd).label < 2 * n && counter < k && !ctns(ribs, ndd + nd)){
                    counter ++;
                    this.addRib(ndd, nd, 1);
                    res.add(ndd + nd);
                }
                for (Node ns: nodes.values()) {
                    ns.label = 2147483646;
                }
            }
        }
        return res;
    }
    private boolean ctns(List<String> lst, String str){
        for (String s : lst) {
            if(Objects.equals(s, str)){
                return true;
            }
        }
        return false;
    }

    private MyLinkedList<Rib> search(Node node, Node nodeDestination) {
        MyQueue<String> queue = new MyQueue<>();
        MyLinkedList<String> list = new MyLinkedList<>();
        MyLinkedList<String> listBeg = new MyLinkedList<>();
        MyLinkedList<Rib> res = new MyLinkedList<>();
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
 //       return counter;
        return null;
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

    public MyLinkedList<String> dijkstraAlgorithm(Node node, Node destinationNode){
        node.label = 0;
        HashSet<String> passedNodes = new HashSet<>();
        HashSet<String> notPassedNodes = new HashSet<>(nodes.keySet());
        HashSet<String> expectedPassedNodes = new HashSet<>();
        expectedPassedNodes.add(node.name);
        Node w = node;
        while(notPassedNodes.size() != 0){
            for (Rib rib: w.ribs) {
                if(w.label + rib.weight < rib.destinationNode.label){
                    rib.destinationNode.label = w.label + rib.weight;
                    expectedPassedNodes.add(rib.destinationNode.name);
                    this.get(rib.destinationNode.name).before = w.name;
                }
            }
            expectedPassedNodes.remove(w.name);
            notPassedNodes.remove(w.name);
            passedNodes.add(w.name);
            w = this.get(this.min(expectedPassedNodes));
        }
        for (String nd : nodes.keySet()) {
            System.out.print(nd + " " +get(nd).label + " ; ");
        }
        System.out.println();
        MyLinkedList<String> res= new MyLinkedList<>();
        String curr = destinationNode.name;
//        while( curr != null) {
//            res.add(curr);
//            System.out.println(this.get(curr).name);
//            curr = this.get(curr).before;
//        }
        return res;
    }

    private String min(HashSet<String> set){
        int lenght = 1000;
        String min = "";

        for (String str: set) {
            if(str.length() < lenght){
                min = str;
                lenght = str.length();
            }
        }
        return min;

    }

}
