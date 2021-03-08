package com.ravensoftware.oystercard.model;

import org.junit.Test;

import static junit.framework.TestCase.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by bilga on 08-03-2021
 */
public class OysterCardTest implements Serializable {

    @Test
    public void should_Assign_Id_When_Created() {
        OysterCard classUnderTest = new OysterCard("1244", new BigDecimal(35));
        assertNotNull(classUnderTest.getId());
    }

    @Test
    public void ids_Should_Be_Different() {
        OysterCard classUnderTest1 = new OysterCard("2213", new BigDecimal(25));
        OysterCard classUnderTest2 = new OysterCard("3121", new BigDecimal(35));

        assertFalse(classUnderTest1.getId().equals(classUnderTest2.getId()));
    }

    @Test
    public void should_Be_Different() {
        OysterCard classUnderTest1 = new OysterCard("2213", new BigDecimal(25));
        OysterCard classUnderTest2 = new OysterCard("2213", new BigDecimal(25));

        assertNotSame(classUnderTest1, classUnderTest2);
    }
}
