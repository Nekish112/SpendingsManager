package com.spendingsmanager.entities;

import com.spendingsmanager.base.entities.StandardEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public class Counting extends StandardEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENTTYPE")
    private PaymentType paymentType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE")
    private Date date;
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSubject() {
        return null;
    }
}
