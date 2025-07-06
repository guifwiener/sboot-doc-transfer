package com.example.springconcepts.bankOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "BANK_ORDER")
public class BankOrderModel {

    @Id
    private Long id;

    @Column(name = "order_value")
    private Integer orderValue;

}
