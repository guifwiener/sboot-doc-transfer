package com.example.transfer.bankOrder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankOrder")
public class BankOrderController {

    private final BankOrderService bankOrderService;

    public BankOrderController(BankOrderService bankOrderService) {
        this.bankOrderService = bankOrderService;
    }

    @PostMapping
    public ResponseEntity<BankOrderModel> postBankOrder(
            @RequestBody BankOrderDto bankOrderDto
    ) throws Exception {

        return ResponseEntity.ok().body(bankOrderService.registerTransaction(bankOrderDto));

    }

}
