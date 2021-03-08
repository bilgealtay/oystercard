package com.ravensoftware.oystercard.service;

import com.ravensoftware.oystercard.model.Station;
import com.ravensoftware.oystercard.model.TransportType;
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
public class AmountServiceTest {

    @Autowired
    private AmountService amountService;

    private Station start;
    private Station end;
    private BigDecimal fare;

    @Test
    public void should_Check_For_Bus() {
        start = Station.EARLS_COURT;
        end = Station.CHELSEA;
        fare = amountService.calculateFare(start, end, TransportType.BUS);
        assertThat(BigDecimal.valueOf(1.8)).isEqualTo(fare);
    }

    @Test
    public void should_Check_For_Zone1_Tube() {
        start = Station.HOLBORN;
        end = Station.EARLS_COURT;
        fare = amountService.calculateFare(start, end, TransportType.TUBE);
        assertThat(BigDecimal.valueOf(2.5)).isEqualTo(fare);
    }

    @Test
    public void should_Check_For_Except_Zone1_Tube() {
        start = Station.EARLS_COURT;
        end = Station.HAMMERSMITH;
        fare = amountService.calculateFare(start, end, TransportType.TUBE);
        assertThat(BigDecimal.valueOf(2)).isEqualTo(fare);
    }

    @Test
    public void should_Check_For_Zone1_And_Other_Zones_Tube() {
        start = Station.EARLS_COURT;
        end = Station.WIMBLEDON;
        fare = amountService.calculateFare(start, end, TransportType.TUBE);
        assertThat(BigDecimal.valueOf(3)).isEqualTo(fare);
    }

    @Test
    public void should_Check_For_Between_Other_Zones_Tube() {
        start = Station.HAMMERSMITH;
        end = Station.WIMBLEDON;
        fare = amountService.calculateFare(start, end, TransportType.TUBE);
        assertThat(BigDecimal.valueOf(2.25)).isEqualTo(fare);
    }

    @Test
    public void should_Check_For_Include_Zone1_between_Different_Zone() {
        start = Station.EARLS_COURT;
        end = Station.WIMBLEDON;
        fare = amountService.calculateFare(start, end, TransportType.TUBE);
        assertThat(BigDecimal.valueOf(3)).isEqualTo(fare);
    }
}