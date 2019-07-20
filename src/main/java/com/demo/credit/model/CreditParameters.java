package com.demo.credit.model;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CreditParameters {
    @NotNull
    @Min(value = 100000, message = "Минимальный размер кредита - 100000")
    @Max(value = 5000000, message = "Максимальный размер кредита - 5000000")
    private Double size;

    @NotNull
    @Min(value = 12, message = "Минимальный период - 12 месяцев")
    @Max(value = 60, message = "Максимальный период - 60 месяцев")
    private Integer period;

    @NotNull
    @DecimalMin(value = "12.9", message = "Минимальная процентная ставка - 12.9%")
    @DecimalMax(value = "23.9", message = "Максимальная процентная ставка - 23.9%")
    private Double yearPercent;

    private LocalDate firstPaymentDate = LocalDate.now().plus(1, ChronoUnit.MONTHS);

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getYearPercent() {
        return yearPercent;
    }

    public void setYearPercent(Double yearPercent) {
        this.yearPercent = yearPercent;
    }

    public LocalDate getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(LocalDate firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }
}
