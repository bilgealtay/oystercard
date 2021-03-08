package com.ravensoftware.oystercard.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by bilga on 08-03-2021
 */
public class OysterCard implements Serializable {

    private static AtomicLong counter = new AtomicLong();

    private Long id;
    private String cardNo;
    private BigDecimal balance;

    public OysterCard() {
        // empty
    }

    public OysterCard(String cardNo, BigDecimal balance) {
        this.id = counter.incrementAndGet();
        this.cardNo = cardNo;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
