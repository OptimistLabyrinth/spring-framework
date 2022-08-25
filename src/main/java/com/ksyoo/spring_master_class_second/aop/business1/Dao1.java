package com.ksyoo.spring_master_class_second.aop.business1;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    public String retrieveSomething() {
        return "Dao1";
    }
}
