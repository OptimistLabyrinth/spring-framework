package com.ksyoo.spring_master_class.junit_and_mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoBusinessImplMockAnnotationTest {
    @Mock
    DataService dataService;

    @InjectMocks
    MockitoBusinessImpl mockitoBusinessImpl;

    @Test
    public void testFindTheGreatestFromAllData() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{24, 7, 15});
        var result = mockitoBusinessImpl.findTheGreatestFromAllData();
        assertEquals(24, result);
    }

    @Test
    public void testFindTheGreatestFromOnlyOneData() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{11});
        var result = mockitoBusinessImpl.findTheGreatestFromAllData();
        assertEquals(11, result);
    }

    @Test
    public void testFindTheGreatestFromZeroData() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{});
        var result = mockitoBusinessImpl.findTheGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE, result);
    }
}
