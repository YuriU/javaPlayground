package com.yuriiu28min.springin5steps;

import org.springframework.stereotype.Component;

@Component
public class SomeCDIDao {

    int[] getData() {
        return new int[] { 1, 2, 4, 5};
    }
}
