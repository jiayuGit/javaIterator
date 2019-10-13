package com.interrator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Code51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        if ((x+"").length()==2){
            n = n-(x%10);
        }
        n=n/(x/10);
        System.out.println();
    }

    private static Integer getMa(HashMap<Integer,Integer> hashMap, int i) {
        while (hashMap.containsKey(i)){
            i=hashMap.get(i);
        }
        return i;
    }
}
