package com.example.springconcepts.bankOrder;

public class BankOrderMapper {

    public static BankOrderModel convertDtoToModel(BankOrderDto bankOrderDto) {

        BankOrderModel bankOrderModel = BankOrderModel.builder()
                .orderValue(bankOrderDto.getOrderValue())
                .build();

        return bankOrderModel;

    }

}
