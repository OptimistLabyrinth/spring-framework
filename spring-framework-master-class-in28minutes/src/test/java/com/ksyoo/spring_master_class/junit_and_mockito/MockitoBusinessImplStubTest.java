package com.ksyoo.spring_master_class.junit_and_mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoBusinessImplStubTest {
    @Test
    public void testFindTheGreatestFromAllData() {
        MockitoBusinessImpl mockitoBusiness = new MockitoBusinessImpl(new DataServiceStub());
        var result = mockitoBusiness.findTheGreatestFromAllData();
        assertEquals(24, result);
    }
}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{24, 6, 15};
    }
}
