package com.spendingsmanager.entities;

import com.spendingsmanager.base.entities.security.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SPENDER")
public class Spender extends User {
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "FULLNAME")
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Spending> spendings;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Spending> getSpendings() {
        return spendings;
    }

    public void setSpendings(Set<Spending> spendings) {
        this.spendings = spendings;
    }
}
