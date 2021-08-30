package com.example.Cupon.resources;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.List;

public class CouponResource {

    public ArrayList<String> getItem_ids() {
        return item_ids;
    }

    @Ignore
    public void setItem_ids(ArrayList<String> item_ids) {
        this.item_ids = item_ids;
    }

    @Ignore
    public Float getAmount() {
        return amount;
    }

    @Ignore
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    private ArrayList<String> item_ids;
    private Float amount;

    public CouponResource(ArrayList<String> item_ids, Float amount) {
        this.item_ids = item_ids;
        this.amount = amount;
    }
}
