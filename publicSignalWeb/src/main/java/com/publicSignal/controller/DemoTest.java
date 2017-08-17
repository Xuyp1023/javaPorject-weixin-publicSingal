package com.publicSignal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DemoTest {

    public static void main(String[] args) {
        
        List<String> list=new ArrayList<>();
        String anStr=".publicSignal.controller.DemoTest";
        StringTokenizer tokenizer = new StringTokenizer(anStr, ".");
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }

        //System.out.println(list.size());
        System.out.println(list);
        

    }

}
