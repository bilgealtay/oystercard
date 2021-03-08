package com.ravensoftware.oystercard.service;

import com.ravensoftware.oystercard.model.OysterCard;
import com.ravensoftware.oystercard.model.Station;
import com.ravensoftware.oystercard.model.TransportType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by bilga on 08-03-2021
 */
@Service
public class OysterCardService {

    private AmountService amountService;

    private OysterCard oysterCard = new OysterCard("dsada", BigDecimal.valueOf(30));

    public OysterCardService(AmountService amountService) {
        this.amountService = amountService;
    }

    public BigDecimal getOysterBalance(Station startPoint, Station endPoint, TransportType transportType){

        BigDecimal fare = amountService.calculateFare(startPoint, endPoint, transportType);
        oysterCard.setBalance(oysterCard.getBalance().subtract(fare));
        return oysterCard.getBalance();
    }
}
