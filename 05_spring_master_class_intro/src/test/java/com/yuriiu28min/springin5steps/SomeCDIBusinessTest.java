package com.yuriiu28min.springin5steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = SpringIn5StepsApplication.class)
public class SomeCDIBusinessTest {
    @Autowired
    @InjectMocks
    SomeCDIBusiness business;

    @Mock
    SomeCDIDao daoMock;


    @Test
    public void testBasicScenario() {
        Mockito.when(daoMock.getData()).thenReturn(new int[] { 1, 3, 4 });
        int result = business.findGreatest();
        assertEquals(4, result);
    }
}