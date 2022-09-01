package com.ksyoo.spring_master_class_second.aop.data;

import com.ksyoo.spring_master_class_second.aop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    @TrackTime
    public String retrieveSomething() {
        return "Dao1";
    }
}
