package com.in28minutes.spring.aop.springaop.data;

import com.in28minutes.spring.aop.springaop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String retrieveSomething() {

        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException ex) {
        }

        return "Dao1";
    }
}
