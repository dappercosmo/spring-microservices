package com.mybank.app.repository;

import com.mybank.app.model.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KyCRepository extends JpaRepository<Kyc, Long> {
}
