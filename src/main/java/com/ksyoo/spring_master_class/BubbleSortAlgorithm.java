package com.ksyoo.spring_master_class;

import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm implements SortAlgorithm {
    public int[] sort(int [] number) {
        System.out.println("bubble sort");
        // * logic for bubble sort
        return number;
    }
}
