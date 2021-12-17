package com.spendingsmanager.entities;

import com.spendingsmanager.base.entities.security.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "SPENDING")
public class Spending extends Counting {

    private static final SimpleDateFormat STANDARD_FORMATTER = new SimpleDateFormat("YYYY-MM-DD");

    @Enumerated(EnumType.STRING)
    @Column(name = "SPENDINGTYPE")
    private SpendingType spendingType;

    public Spending(User user,
                    String paymentType,
                    String spendingType,
                    String date,
                    String amount) {
        setUser(user);


        setPaymentType(paymentType != null && !paymentType.equals("") ? PaymentType.valueOf(paymentType) : null);
        setSpendingType(spendingType != null && !spendingType.equals("") ? SpendingType.valueOf(spendingType) : null);
        try {
            setDate(date != null && !date.equals("") ? STANDARD_FORMATTER.parse(date) : null);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            setDate(null);
        }
        setAmount(amount != null && !amount.equals("") ? new BigDecimal(amount) : null);
    }

    public Spending() {}

    public SpendingType getSpendingType() {
        return spendingType;
    }

    public void setSpendingType(SpendingType spendingType) {
        this.spendingType = spendingType;
    }

    @Override
    public String getSubject() {
        return spendingType != null ? spendingType.getLabel() : null;
    }
}
