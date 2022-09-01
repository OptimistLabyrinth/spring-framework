package com.ksyoo.spring_master_class.understanding_autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

@Service
public class BubbleSortAlgorithm implements SortAlgorithm {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public BubbleSortAlgorithm() {
        LOGGER.info("Bubble Sort Algorithm OK");
    }

    public int[] sort(int [] number) {
        LOGGER.info("bubble sort");
        // * logic for bubble sort
        return number;
    }
//
//    @PostConstruct
//    public void postConstruct() {
//        LOGGER.info("    postConstruct BubbleSortAlgorithm Bean");
//    }
//
//    @PreDestroy
//    public void PreDestroy() { LOGGER.info("    PreDestroy BubbleSortAlgorithm Bean"); }
}
