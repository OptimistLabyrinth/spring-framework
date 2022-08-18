package com.ksyoo.spring_master_class;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorithm {
    public int[] sort(int [] number) {
        System.out.println("quick sort");
        // * logic for quick sort
        return number;
    }
}
