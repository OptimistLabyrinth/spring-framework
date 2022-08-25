package com.ksyoo.spring_master_class_second.aop.business2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service2 {
    @Autowired
    private final Dao2 dao2;

    public Service2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        return dao2.retrieveSomething();
    }
}
