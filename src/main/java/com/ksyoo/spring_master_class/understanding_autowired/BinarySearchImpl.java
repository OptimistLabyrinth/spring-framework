package com.ksyoo.spring_master_class.understanding_autowired;

import com.ksyoo.spring_master_class.SpringMasterClassApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
        LOGGER.info("Binary Search Implementation OK");
    }

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        // * sort an array
        var sortedNumbers = sortAlgorithm.sort(numbers);
        // * search the array
        // * return the result
        return 3;
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("    postConstruct BinarySearchImpl Bean");
    }

    @PreDestroy
    public void PreDestroy() { LOGGER.info("    PreDestroy BinarySearchImpl Bean"); }
}
