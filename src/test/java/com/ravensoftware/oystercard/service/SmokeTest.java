package com.ravensoftware.oystercard.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bilga on 08-03-2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private AmountService amountService;
    @Autowired
    private OysterCardService oysterCardService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(amountService).isNotNull();
        assertThat(oysterCardService).isNotNull();
    }
}
