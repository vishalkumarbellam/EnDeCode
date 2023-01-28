package com.example.en_decode;


import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCode implements Comparable<HuffmanCode>{

    private char c;
    private int val;
    HuffmanCode left,right;

    HuffmanCode(char c,int val)
    {
        this.c=c;
        this.val=val;
    }
    HuffmanCode(char c,int val,HuffmanCode left,HuffmanCode right)
    {
        this.c=c;
        this.val=val;
        this.left=left;
        this.right=right;
    }

    @Override
    public int compareTo(HuffmanCode h) {
        return this.val-h.val;
    }

    static String shorten(String s)
    {
        //declaration and initialization of variables
        String reducedText="";
        int i=0;char c;
        PriorityQueue<HuffmanCode> pq=new PriorityQueue<HuffmanCode>();
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,String> codes=new HashMap<>();

        //storing frequency of each character
        for(c=s.charAt(i);i<s.length();i++)
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);

        //adding all the values of the HashMap created as HuffmanCode object (Creating leaf nodes)
        for(char ch: map.keySet())
             pq.add(new HuffmanCode(ch,map.get(ch)));

        //creating Huffman Tree
        while(pq.size()>1)
            pq.add(new HuffmanCode(' ',pq.peek().val+pq.peek().val,pq.poll(),pq.poll()));

        //storing the generated huffmancodes
        createCodes(pq.peek(),codes,"");

        //creating the reduced string
        i=0;
        for(c=s.charAt(i);i<s.length();i++)
            reducedText+=codes.get(c);

        return reducedText;
    }

    //method to generate huffmancodes
    static void createCodes(HuffmanCode hc,HashMap<Character,String> map,String s){
        if(hc.left==null){
            map.put(hc.c,s);
            return;
        }
        createCodes(hc.left,map,s+"0");
        createCodes(hc.right,map,s+"1");
    }
}
