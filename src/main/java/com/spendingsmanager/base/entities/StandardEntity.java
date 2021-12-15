package com.spendingsmanager.base.entities;

import com.spendingsmanager.base.entities.security.User;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class StandardEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
