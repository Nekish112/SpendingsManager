package com.spendingsmanager.repositories;

import com.spendingsmanager.base.repositories.StandardDomainRepository;
import com.spendingsmanager.entities.Spending;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingRepository extends StandardDomainRepository<Spending> {
}
