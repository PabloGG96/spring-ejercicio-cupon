package com.example.Cupon.requestmodels;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

public class CouponRequest {


    public ArrayList<String> getItem_ids() {
        return item_ids;
    }

    public void setItem_ids(ArrayList<String> item_ids) {
        this.item_ids = item_ids;
    }

    @JsonSerialize
    private ArrayList<String> item_ids;
    @JsonSerialize
    private float amount;


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    public CouponRequest(ArrayList<String> item_ids, float amount) {
        this.item_ids = item_ids;
        this.amount = amount;
    }



}
