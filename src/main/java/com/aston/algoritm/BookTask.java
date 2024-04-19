package com.aston.algoritm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookTask {

    public static <E> int isSort(List <Integer> list, Integer item) {
        int low = 0;
        int high = list.size()-1;
        if (high<=0){
            return 0;
        }



        while (low<=high) {
            int mid = (low+high)/2;
           Integer guess =  list.get(mid);
            if (guess==item){
                return mid;
            }
            if(guess > item) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }return 0;
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        isSort(list,7);

    }
}
