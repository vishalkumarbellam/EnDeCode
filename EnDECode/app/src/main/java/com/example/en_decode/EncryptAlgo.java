package com.example.en_decode;

import java.util.HashMap;
import java.util.HashSet;

public class EncryptAlgo {

    static String monoAlpha(String s){

        //declaration and initialization
        char chr;
        String c="",key="";
        //map to store mapping of every kind of alphabet
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> hs=new HashSet<>();

        for(chr='a';chr<='z';chr++)
            map.put(chr,(char)(Tools.linearProbe(new Tools().hashCode()%26)+97));
        for(int i=0;i<s.length();i++){
            chr=s.charAt(i);
            if(Character.isUpperCase(chr))
                c+=map.get(Character.toLowerCase(chr));
            else
                c+=map.get(chr);
            hs.add(chr);
        }
        for(char ch:hs){
            key+=map.get(ch);
            key+=ch;
        }
        key+=("x"+key.length());
        return c+key;
    }

    static String ceaserCipher(String s){

        //declaration and initialization
        int key=new Tools().hashCode();
        String cipherText="";

        //converting every character of the string a/c to the generated key
        for(int i=0;i<s.length();i++){
            cipherText+=(char)((key+s.charAt(i))%256);
        }

        //adding key at the end of the cipher text
        cipherText+=("x"+key);

        return cipherText;
    }

    static String des(int n)
    {
        String s="";
        return s;
    }

}
