package com.ksyoo.spring_master_class.understanding_cdi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SomeCdiServiceTest {
    @Mock
    SomeCdiDao someCdiDao;

    @InjectMocks
    SomeCdiService someCdiService;

    @Test
    public void testBasicService() {
        when(someCdiDao.getData()).thenReturn(new int[]{2,4,1515});
        int greatestValue = someCdiService.findGreatest();
        assertEquals(1515, greatestValue);
    }
}
