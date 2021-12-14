package com.spendingsmanager.base.repositories;

import com.spendingsmanager.base.entities.StandardEntity;
import com.spendingsmanager.base.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface StandardDomainRepository<T extends StandardEntity> extends JpaRepository<T, Long> {
    List<T> findByUser(User user);
}
