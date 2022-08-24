package com.ksyoo.spring_master_class;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(MockitoExtension.class)
@SpringJUnitConfig(classes = SpringMasterClassApplication.class)
class SpringMasterClassApplicationTests {
	@Test
	void contextLoads() {
	}
}
