package com.in28minutes.mockito.mockitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplTest {

    @Test
    public void testFindTheGreatestFromAllData() {

        DataService dataService = mock(DataService.class);

        when(dataService.retrieveAllData()).thenReturn(new int[] { 2, 3, 4 });

        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);

        int greatest = businessImpl.findTheGreatestFromAllData();

        assertEquals(4, greatest);
    }

}