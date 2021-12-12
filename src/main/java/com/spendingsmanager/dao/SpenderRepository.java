package com.spendingsmanager.dao;

import com.spendingsmanager.entities.Spender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpenderRepository extends JpaRepository<Spender, Long> {
    Spender findByUsername(String username);
}
