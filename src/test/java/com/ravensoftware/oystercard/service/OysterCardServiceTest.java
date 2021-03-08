package com.ravensoftware.oystercard.service;

import com.ravensoftware.oystercard.model.OysterCard;
import com.ravensoftware.oystercard.model.Station;
import com.ravensoftware.oystercard.model.TransportType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by bilga on 08-03-2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class OysterCardServiceTest {

    @Autowired
    private OysterCardService oysterCardService;
    @Autowired
    private AmountService amountService;

    private OysterCard oysterCard;

    @Before
    public void init() {
        oysterCard = new OysterCard("2123", BigDecimal.valueOf(30));
    }

    @Test
    public void should_Check_Oyster_Card_Balance() {
        Station start = Station.HOLBORN;
        Station end = Station.EARLS_COURT;
        BigDecimal fare = amountService.calculateFare(start, end, TransportType.TUBE);
        oysterCard.setBalance(oysterCard.getBalance().subtract(fare));

        assertThat(oysterCard.getBalance()).isEqualTo(oysterCardService.getOysterBalance(start, end, TransportType.TUBE));

    }

}