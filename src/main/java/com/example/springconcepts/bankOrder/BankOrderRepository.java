package com.example.springconcepts.bankOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankOrderRepository extends JpaRepository<BankOrderModel, Long> {



}
