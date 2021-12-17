package com.spendingsmanager.repositories;

import com.spendingsmanager.base.repositories.security.StandardUserRepository;
import com.spendingsmanager.entities.Spender;
import org.springframework.stereotype.Repository;

@Repository
public interface SpenderRepository extends StandardUserRepository<Spender> {
}
