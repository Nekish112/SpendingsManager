package com.spendingsmanager.entities;

import com.spendingsmanager.base.entities.StandardEntity;
import com.spendingsmanager.base.entities.security.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "SPENDING")
public class Spending extends StandardEntity {

    private static final SimpleDateFormat STANDARD_FORMATTER = new SimpleDateFormat("YYYY-MM-DD");

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENTTYPE")
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    @Column(name = "SPENDINGTYPE")
    private SpendingType spendingType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE")
    private Date date;
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public Spending(User user,
                    String paymentType,
                    String spendingType,
                    String date,
                    String amount) {
        setUser(user);


        this.paymentType = paymentType != null && !paymentType.equals("") ? PaymentType.valueOf(paymentType) : null;
        this.spendingType = spendingType != null && !spendingType.equals("") ? SpendingType.valueOf(spendingType) : null;
        try {
            this.date = date != null && !date.equals("") ? STANDARD_FORMATTER.parse(date) : null;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            this.date = null;
        }
        this.amount = amount != null && !amount.equals("") ? new BigDecimal(amount) : null;
    }

    public Spending() {}

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

    public SpendingType getSpendingType() {
        return spendingType;
    }

    public void setSpendingType(SpendingType spendingType) {
        this.spendingType = spendingType;
    }
}
