package com.spendingsmanager.dao;

import com.spendingsmanager.base.repositories.StandardDomainRepository;
import com.spendingsmanager.entities.Income;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends StandardDomainRepository<Income> {
}
