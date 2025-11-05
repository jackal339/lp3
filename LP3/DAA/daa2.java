//Write a program to implement Huffman Encoding using a greedy strategy.

import java.util.*;

class Node{
    char ch;
    int freq;
    Node left;
    Node right;

    Node(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

public class daa2 {
    
    static void printHuff(Node root, String code){
        if(root == null) return;
        if(root.left == null && root.right == null && Character.isLetter(root.ch)){
            System.out.println(root.ch + ": " + code);
        }
        printHuff(root.left, code+"0");
        printHuff(root.right, code+"1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter total no. of unique characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] fr = new int[n];
        
        System.out.println("enter letters: ");
        for(int i=0; i<n; i++){
            chars[i] = sc.next().charAt(0);
        }

        System.out.println("enter frequencies: ");
        for(int i=0; i<n; i++){
            fr[i] = sc.nextInt();
        }

        PriorityQueue <Node> pq = new PriorityQueue<>((x,y)->x.freq-y.freq);

        for(int i=0; i<n; i++){
            pq.add(new Node(chars[i], fr[i]));
        }

        while(pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        Node root = pq.peek();
        printHuff(root, "");

        sc.close();
    }
}
