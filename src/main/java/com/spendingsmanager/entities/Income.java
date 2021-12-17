package com.spendingsmanager.entities;

import com.spendingsmanager.base.entities.security.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "INCOME")
public class Income extends Counting {

    private static final SimpleDateFormat STANDARD_FORMATTER = new SimpleDateFormat("YYYY-MM-DD");

    @Enumerated(EnumType.STRING)
    @Column(name = "INCOMETYPE")
    private IncomeType incomeType;

    public Income(User user, String paymentType, String incomeType, String date, String amount) {
        setUser(user);

        setPaymentType(paymentType != null && !paymentType.equals("") ? PaymentType.valueOf(paymentType) : null);
        setIncomeType(incomeType != null && !incomeType.equals("") ? IncomeType.valueOf(incomeType) : null);
        try {
            setDate(date != null && !date.equals("") ? STANDARD_FORMATTER.parse(date) : null);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            setDate(null);
        }
        setAmount(amount != null && !amount.equals("") ? new BigDecimal(amount) : null);
    }

    public Income() {}

    @Override
    public String getSubject() {
        return incomeType != null ? incomeType.getLabel() : null;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }
}
