package com.demo.credit.service;

import com.demo.credit.model.CreditParameters;
import com.demo.credit.model.Payment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CreditService {
    public List<Payment> calculate(CreditParameters params) {
        List<Payment> result = new ArrayList<>();

        Payment oneOfPayments = new Payment();
        oneOfPayments.setPrimaryDebtPayment(100);
        oneOfPayments.setPercentPayment(10);
        oneOfPayments.setRemainingDebt(1000);
        oneOfPayments.setAllPayment(110);
        result.add(oneOfPayments);

        return result;
    }
}
