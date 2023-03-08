package Task3;

import Task2.MyLinkedList;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        MyPriorityQueue q = new MyPriorityQueue();
        solution(q, new File("fileFor3Task.txt"));
        q.write();

    }
    public static void solution(MyPriorityQueue queue, File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String temp = "";
        while (br.ready()){
            temp += br.readLine() + " ";
        }
        String[] res = temp.split("[^\\w\\d\\s] |\\s");
        for (String i : res) {
            queue.add(i);
        }

    }
}
