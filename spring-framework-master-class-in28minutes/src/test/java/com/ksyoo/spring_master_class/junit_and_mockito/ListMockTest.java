package com.ksyoo.spring_master_class.junit_and_mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {
    @Test
    public void testSizeOnce() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, listMock.size());
    }

    @Test
    public void testSizeMultipleTImes() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
        assertEquals(20, listMock.size());
    }

    @Test
    public void testGet() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("something");
        assertEquals("something", listMock.get(0));
    }

    @Test
    public void testGetAlways() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("something");
        assertEquals("something", listMock.get(0));
        assertEquals("something", listMock.get(1));
    }
}
