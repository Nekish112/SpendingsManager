package com.spendingsmanager.dao;

import com.spendingsmanager.entities.Spender;
import com.spendingsmanager.entities.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {
    List<Spending> findBySpender(Spender spender);
}
