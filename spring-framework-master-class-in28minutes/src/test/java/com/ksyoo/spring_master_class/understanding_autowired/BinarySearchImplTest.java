package com.ksyoo.spring_master_class.understanding_autowired;

import com.ksyoo.spring_master_class.SpringMasterClassApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = SpringMasterClassApplication.class)
public class BinarySearchImplTest {
    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    public void testBasic() {
        var result = binarySearch.binarySearch(new int[]{3, 17, 92}, 17);
        assertEquals(3, result);
    }
}
