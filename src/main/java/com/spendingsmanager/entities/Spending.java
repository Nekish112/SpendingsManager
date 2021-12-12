package com.spendingsmanager.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "SPENDING")
public class Spending {

    private static final SimpleDateFormat STANDARD_FORMATTER = new SimpleDateFormat("YYYY-MM-DD");

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Spender spender;
    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENTTYPE")
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    @Column(name = "SPENDINGTYPE")
    private SpendingType spendingType;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "AMOUNT")
    private BigDecimal amount;

    public Spending(Spender spender,
                    String paymentType,
                    String spendingType,
                    String date,
                    String amount) {
        this.spender = spender;


        this.paymentType = paymentType != null && !paymentType.equals("") ? PaymentType.valueOf(paymentType) : null;
        this.spendingType = spendingType != null && !spendingType.equals("") ? SpendingType.valueOf(spendingType) : null;
        try {
            this.date = date != null && !date.equals("") ? STANDARD_FORMATTER.parse(date) : null;
        } catch (ParseException e) {
            this.date = null;
        }
        this.amount = amount != null && !amount.equals("") ? new BigDecimal(amount) : null;
    }

    public Spending() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Spender getSpender() {
        return spender;
    }

    public void setSpender(Spender spender) {
        this.spender = spender;
    }
}
