package br.com.jonathanferreira.store.vo;

import java.time.LocalDate;

public class SalesReportVO {

    private final String productName;
    private final Long quantitySold;
    private final LocalDate lastDateSold;

    public SalesReportVO(String productName, Long quantitySold, LocalDate lastDateSold) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.lastDateSold = lastDateSold;
    }

    public String getProductName() {
        return productName;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public LocalDate getLastDateSold() {
        return lastDateSold;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", productName, quantitySold, lastDateSold);
    }
}
