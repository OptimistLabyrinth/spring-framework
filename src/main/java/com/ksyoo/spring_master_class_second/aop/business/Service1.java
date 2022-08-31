package com.ksyoo.spring_master_class_second.aop.business;

import com.ksyoo.spring_master_class_second.aop.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 {
    @Autowired
    private final Dao1 dao1;

    public Service1(Dao1 dao1) {
        this.dao1 = dao1;
    }

    public String calculateSomething() {
        return dao1.retrieveSomething();
    }
}
