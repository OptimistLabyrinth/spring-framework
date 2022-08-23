package com.ksyoo.spring_master_class.junit_and_mockito;

public class MockitoBusinessImpl {
    private DataService dataService;

    public MockitoBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;
        for (int value : data)
            if (value > greatest)
                greatest = value;
        return greatest;
    }
}
