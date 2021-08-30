package com.example.Cupon.resources;

import com.example.Cupon.responses.CouponResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CouponResourceTest {

    @Autowired
    CouponResource couponResource;

    @BeforeEach
    void setUp(){

        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448457");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 675f;
        couponResource = new CouponResource(item_ids,amount);

    }

    @Test
    void getItem_ids() {
        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448457");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        //couponResponse.setItem_ids(item_ids);

        Assertions.assertEquals(item_ids,couponResource.getItem_ids());


    }

    @Test
    void setItem_ids() {
        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448458");
        item_ids.add("MLA670752298");
        item_ids.add("MLA910455609");
        couponResource.setItem_ids(item_ids);

        Assertions.assertEquals(item_ids,couponResource.getItem_ids());

    }

    @Test
    void getAmount() {

        float total = 675f;
        Assertions.assertEquals(total,couponResource.getAmount());

    }

    @Test
    void setAmount() {
        float newAmount = 800f;
        couponResource.setAmount(newAmount);
        Assertions.assertEquals(newAmount,couponResource.getAmount());

    }
}