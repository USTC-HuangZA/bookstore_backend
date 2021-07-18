package com.reins.bookstore.entity.vo;

/**
 * @author ziang
 */
public class BookStatistic {
    private Integer bookNumber;
    private Integer bookInventorySum;

    public Integer getBookInventorySum() {
        return bookInventorySum;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookInventorySum(Integer bookInventorySum) {
        this.bookInventorySum = bookInventorySum;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }
}
