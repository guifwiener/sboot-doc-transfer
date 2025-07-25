package com.example.transfer.bankOrder;

import com.example.transfer.connections.RabbitMQConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankOrderService {

    private final RabbitMQConfiguration rabbitMQConfiguration;

    private final BankOrderRepository bankOrderRepository;

    public BankOrderService(BankOrderRepository bankOrderRepository, RabbitMQConfiguration rabbitMQConfiguration) {
        this.bankOrderRepository = bankOrderRepository;
        this.rabbitMQConfiguration = rabbitMQConfiguration;
    }

    public BankOrderModel registerTransaction(BankOrderDto bankOrderDto) throws Exception {

        BankOrderModel bankOrderModel = BankOrderMapper.convertDtoToModel(bankOrderDto);
        BankOrderModel bankOrder = bankOrderRepository.save(bankOrderModel);
        rabbitMQConfiguration.publish("Transação enviada");
        return bankOrder;

    }

}
