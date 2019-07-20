package com.demo.credit.service;

import com.demo.credit.model.CreditParameters;
import com.demo.credit.model.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
public class CreditService {

    private int MONTHS_IN_YEAR = 12;

    public List<Payment> calculate(CreditParameters params) {
        double absolutePercentValue = getAbsolutePercentValue(params.getYearPercent());

        double annuitPayment = calculateAnnuitPaymant(params.getSize(), absolutePercentValue, params.getPeriod());

        List<Payment> result = new ArrayList<>();

        LocalDate date = params.getFirstPaymentDate();
        double remainingDebt = params.getSize();

        for (int i = 0; i < params.getPeriod(); i++) {

            double percentPayment = calculatePercentPayment(absolutePercentValue, remainingDebt);
            double primaryDebtPayment = annuitPayment-percentPayment;


            remainingDebt -= primaryDebtPayment;

            Payment oneOfPayments = new Payment();
            oneOfPayments.setDate(date.format(DateTimeFormatter.ofPattern("MM/yyyy")));
            oneOfPayments.setPrimaryDebtPayment(String.format("%,.2f", primaryDebtPayment));
            oneOfPayments.setPercentPayment(String.format("%,.2f", percentPayment));
            oneOfPayments.setAllPayment(String.format("%,.2f", annuitPayment));
            oneOfPayments.setRemainingDebt(String.format("%,.2f", remainingDebt));

            result.add(oneOfPayments);

            date = date.plus(1, ChronoUnit.MONTHS);
        }

        return result;
    }

    private double calculatePercentPayment(double absoluteYearPercent, double remainingDebt) {
        return remainingDebt * absoluteYearPercent / MONTHS_IN_YEAR;
    }

    private double calculateAnnuitPaymant(double creditSize, double absoluteYearPercent, int period) {
        // 1/12 процентной ставки в абсолютной величине
        double P = absoluteYearPercent / MONTHS_IN_YEAR;

        return creditSize * (P + P /
                (Math.pow(1 + P, period) - 1));
    }

    private double getAbsolutePercentValue(double value) {
        while (value >= 1) {
            value /= 10;
        }
        return value;
    }
}
