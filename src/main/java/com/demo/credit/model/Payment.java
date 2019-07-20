package com.demo.credit.model;

public class Payment {
    private String primaryDebtPayment;
    private String percentPayment;
    private String remainingDebt;
    private String allPayment;

    public String getPrimaryDebtPayment() {
        return primaryDebtPayment;
    }

    public void setPrimaryDebtPayment(String primaryDebtPayment) {
        this.primaryDebtPayment = primaryDebtPayment;
    }

    public String getPercentPayment() {
        return percentPayment;
    }

    public void setPercentPayment(String percentPayment) {
        this.percentPayment = percentPayment;
    }

    public String getRemainingDebt() {
        return remainingDebt;
    }

    public void setRemainingDebt(String remainingDebt) {
        this.remainingDebt = remainingDebt;
    }

    public String getAllPayment() {
        return allPayment;
    }

    public void setAllPayment(String allPayment) {
        this.allPayment = allPayment;
    }
}
