package com.spendingsmanager.base.repositories.security;

import com.spendingsmanager.base.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StandardUserRepository<T extends User> extends JpaRepository<T, Long> {
    T findByUsername(String username);
}
