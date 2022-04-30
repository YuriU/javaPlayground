package com.yuriiu28min.springin5steps;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeCDIBusiness {

    @Autowired
    SomeCDIDao someCDIDao;

    public SomeCDIDao getSomeCDIDao() {
        return someCDIDao;
    }

    public void setSomeCDIDao(SomeCDIDao someCDIDao) {
        this.someCDIDao = someCDIDao;
    }

    public SomeCDIBusiness(SomeCDIDao someCDIDao) {
        this.someCDIDao = someCDIDao;
    }


}
