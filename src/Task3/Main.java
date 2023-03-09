package Task3;

import Task2.MyLinkedList;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
   //     MyPriorityQueue q = new MyPriorityQueue();
        new ManeFrame1();
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return 0;
                }
                else if(o1.length() > o2.length()){
                    return -1;
                }else{
                    return 1;
                }
            }
        };
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
    public static void solution2(PriorityQueue<String> queue, File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String temp = "";
        while (br.ready()) {
            temp += br.readLine() + " ";
        }
        String[] res = temp.split("[^\\w\\d\\s] |\\s");
        for (String i : res) {
            queue.add(i);
        }
    }
}
