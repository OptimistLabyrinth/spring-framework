package com.ksyoo.spring_master_class.junit_and_mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoBusinessImplMockTest {
    @Test
    public void testFindTheGreatestFromAllData() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 7, 15 });
        MockitoBusinessImpl mockitoBusiness = new MockitoBusinessImpl(dataServiceMock);
        var result = mockitoBusiness.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    @Test
    public void testFindTheGreatestFromOnlyOneData() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 11 });
        MockitoBusinessImpl mockitoBusiness = new MockitoBusinessImpl(dataServiceMock);
        var result = mockitoBusiness.findTheGreatestFromAllData();
        assertEquals(11, result);
    }
}
