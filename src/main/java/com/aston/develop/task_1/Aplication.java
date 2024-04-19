package com.aston.develop.task_1;

import java.util.Collections;
import java.util.Comparator;

public class Aplication {
    public static void main(String[] args) {
        IntensiveList list = new ArrayList_Denis_Shapoval();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("abb");
        list.add("ab");
        list.add("a");
        list.add("abbbb");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(2);


        System.out.println(list.size());

        System.out.print("-------");
        list.split(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }



    }
}
