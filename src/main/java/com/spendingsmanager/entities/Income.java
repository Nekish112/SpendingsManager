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
@Table(name = "INCOME")
public class Income extends StandardEntity {

    private static final SimpleDateFormat STANDARD_FORMATTER = new SimpleDateFormat("YYYY-MM-DD");

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENTTYPE")
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    @Column(name = "INCOMETYPE")
    private IncomeType incomeType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE")
    private Date date;
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public Income(User user, String paymentType, String incomeType, String date, String amount) {
        setUser(user);

        this.paymentType = paymentType != null && !paymentType.equals("") ? PaymentType.valueOf(paymentType) : null;
        this.incomeType = incomeType != null && !incomeType.equals("") ? IncomeType.valueOf(incomeType) : null;
        try {
            this.date = date != null && !date.equals("") ? STANDARD_FORMATTER.parse(date) : null;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            this.date = null;
        }
        this.amount = amount != null && !amount.equals("") ? new BigDecimal(amount) : null;
    }

    public Income() {}

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

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }
}
