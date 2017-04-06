package com.taobao.store.pojo;

import java.math.BigDecimal;

/**
 * Created by kd_gavin on 2017/4/6,15:08.
 *
 * @dicription
 */
public class Product {
    private long id;
    private String number;
    private String name;
    private BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
