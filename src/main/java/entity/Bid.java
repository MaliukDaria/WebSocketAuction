package entity;

import java.math.BigDecimal;

public class Bid {
    private Long id;
    private Customer customer;
    private BigDecimal bitAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getBitAmount() {
        return bitAmount;
    }

    public void setBitAmount(BigDecimal bitAmount) {
        this.bitAmount = bitAmount;
    }
}
