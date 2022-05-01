package com.in28minutes.mockito.mockitodemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImpAnnotationsTest {

    @Mock
    DataService dataService;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void testFindTheGreatestFromAllData() {
        when(dataService.retrieveAllData()).thenReturn(new int[] { 2, 3, 4 });
        int greatest = businessImpl.findTheGreatestFromAllData();
        assertEquals(4, greatest);
    }

    @Test
    public void testFindTheGreatestFromAllData_Empty_NoValue() {
        when(dataService.retrieveAllData()).thenReturn(new int[] { });
        int greatest = businessImpl.findTheGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE, greatest);
    }

}