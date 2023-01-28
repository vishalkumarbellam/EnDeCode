package com.example.en_decode;

import java.util.ArrayList;

public class Tools extends Object{

    static int arr[]=new int[256];

    @Override
    public int hashCode() {
        return (int)(Math.random()*1001);
    }

    static ArrayList<Integer> detectSpaces(String s){
        ArrayList<Integer> al=new ArrayList<>();

        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==' ')
                al.add(i);
        return al;
    }

    static String removeSpaces(String s){
        String x="";

        for(int i=0;i<s.length();i++)
            if(s.charAt(i)!=' ')
                x+=s.charAt(i);
        return x;
    }
    static boolean checkNum(String s){
        for(int i=0;i<s.length();i++)
            if(!Character.isDigit(s.charAt(i)))
                return false;
        return true;
    }

    static boolean checkText(String s){
        for(int i=0;i<s.length();i++)
            if(!Character.isAlphabetic(s.charAt(i)))
                return false;
        return true;
    }

    static boolean checkString(String s){
        for(int i=0;i<s.length();i++)
            if(!Character.isAlphabetic(s.charAt(i))&&!Character.isDigit(s.charAt(i)))
                return false;
        return true;
    }

    static int linearProbe(int x){
        while(arr[x++]==1)
            if(x==256)
                x=0;
        arr[--x]=1;
        return x;
    }
}
