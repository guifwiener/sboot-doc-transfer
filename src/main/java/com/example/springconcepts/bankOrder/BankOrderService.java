package com.example.springconcepts.bankOrder;

import com.example.springconcepts.connections.RabbitMQConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankOrderService {

    private BankOrderModel bankOrderModel;
    private final RabbitMQConfiguration rabbitMQConfiguration;

    private final BankOrderRepository bankOrderRepository;

    public BankOrderService(BankOrderRepository bankOrderRepository, RabbitMQConfiguration rabbitMQConfiguration) {
        this.bankOrderRepository = bankOrderRepository;
        this.rabbitMQConfiguration = rabbitMQConfiguration;
    }

    public BankOrderModel registerTransaction(BankOrderDto bankOrderDto) throws Exception {

//        BankOrderModel bankOrder = bankOrderRepository.save(bankOrderModel);
        rabbitMQConfiguration.publish("Transação enviada");
        return null;

    }

}
