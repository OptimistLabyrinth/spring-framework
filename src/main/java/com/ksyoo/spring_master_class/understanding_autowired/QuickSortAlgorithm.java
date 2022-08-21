package com.ksyoo.spring_master_class.understanding_autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorithm {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public QuickSortAlgorithm() {
        LOGGER.info("Quick Sort Algorithm OK");
    }

    public int[] sort(int [] number) {
        LOGGER.info("quick sort");
        // * logic for quick sort
        return number;
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("    postConstruct QuickSortAlgorithm Bean");
    }

    @PreDestroy
    public void PreDestroy() { LOGGER.info("    PreDestroy QuickSortAlgorithm Bean"); }
}
