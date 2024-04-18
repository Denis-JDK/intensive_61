package com.aston.develop.task_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Напишите программу для подсчета количества конкретных слов в строке, используя HashMap.
 */
public class HashMapWordsCounter {
    public static Map<String, Integer> wordsCounter(String str) {
        Map<String, Integer> map = new HashMap<>();
        List<String> strList = List.of(str.split(" "));
        for (String string: strList) {
            if (map.containsKey(string)) {
                int counter = map.get(string);//передаем ключ а ключ это слово из строки!! и просто увеличиваем значение(Integer) в map
                map.put(string,counter+1);
            }else {
                map.put(string,1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        String st = "This task task will be solved by by by Java developer developer";

        Map<String, Integer> mapa = wordsCounter(st);
        System.out.println(mapa);
    }
}
