package model.util;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
public class FlightFilter {
    private String to;
    private String from;
    private LocalDate firstFlyDate;
    private LocalDate secondFlyDate;
    private BigDecimal minSalePrice;
    private BigDecimal maxSalePrice;

    public void setToAndFrom(String to, String from) {
        this.to = to;
        this.from = from;
    }

    public void setFlyDate(LocalDate firstFlyDate, LocalDate secondFlyDate) {
        this.firstFlyDate = firstFlyDate;
        this.secondFlyDate = secondFlyDate;
    }
    public void setSalePrice(BigDecimal minSalePrice,BigDecimal maxSalePrice){
        this.minSalePrice = minSalePrice;
        this.maxSalePrice = maxSalePrice;
    }

}
