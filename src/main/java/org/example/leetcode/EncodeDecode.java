package org.example.leetcode;
import java.util.*;

public class EncodeDecode {

    public static String encode(List<String> s){
        StringBuilder sb = new StringBuilder();
        for(String i:s){
            String en = i.length()+"#"+i;
            sb.append(en);
        }
        return sb.toString();
    }

    public static List<String> decode(String encoded){
        int n=encoded.length();
        int i=0;
        List<String> decoded = new ArrayList<>();
        while(i<n){
            StringBuilder sb = new StringBuilder();
            int it=i;
            int toSkip=0;
            while (Character.isDigit(encoded.charAt(it))){
                toSkip = toSkip*10 + Character.getNumericValue(encoded.charAt(it));
                it++;
            }
            sb.append(encoded, it+1, it+1+toSkip);
            decoded.add(sb.toString());
            i=it+toSkip+1;
        }
        return decoded;
    }

    public static void main(String[] args){
        List<String> inp = new ArrayList<>();
        inp.add("1,23");
        inp.add("45,6");
        inp.add("7,8,9");
        inp.add("");

        String encoded = encode(inp);
        System.out.println(encoded);
        List<String> decoded = decode(encoded);
        System.out.println(decoded);
    }
}
