package com.ksyoo.spring_master_class.understanding_autowired;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/binarySearchImplTest.xml")
public class BinarySearchImplXmlTest {
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    public void testBasic() {
        var result = binarySearch.binarySearch(new int[]{3, 17, 92}, 17);
        assertEquals(3, result);
    }
}
