package com.demo.credit.model;

public class Payment {
    private double primaryDebtPayment;
    private double percentPayment;
    private double remainingDebt;
    private double allPayment;

    public double getPrimaryDebtPayment() {
        return primaryDebtPayment;
    }

    public void setPrimaryDebtPayment(double primaryDebtPayment) {
        this.primaryDebtPayment = primaryDebtPayment;
    }

    public double getPercentPayment() {
        return percentPayment;
    }

    public void setPercentPayment(double percentPayment) {
        this.percentPayment = percentPayment;
    }

    public double getRemainingDebt() {
        return remainingDebt;
    }

    public void setRemainingDebt(double remainingDebt) {
        this.remainingDebt = remainingDebt;
    }

    public double getAllPayment() {
        return allPayment;
    }

    public void setAllPayment(double allPayment) {
        this.allPayment = allPayment;
    }
}
