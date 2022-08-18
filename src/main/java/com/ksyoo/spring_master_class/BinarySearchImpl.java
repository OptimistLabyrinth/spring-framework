package com.ksyoo.spring_master_class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
    @Autowired
    private final SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        // * sort an array
        var sortedNumbers = sortAlgorithm.sort(numbers);
        // * search the array
        // * return the result
        return 3;
    }
}
