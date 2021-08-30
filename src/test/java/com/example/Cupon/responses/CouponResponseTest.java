package com.example.Cupon.responses;

import com.example.Cupon.services.ItemService;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CouponResponseTest {

    @Autowired
    CouponResponse couponResponse;

    @BeforeEach
    void setUp(){

        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448457");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 675f;
        couponResponse = new CouponResponse(item_ids,amount);

    }

    @Test
    void getItem_ids() {

        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448457");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        //couponResponse.setItem_ids(item_ids);

        Assertions.assertEquals(item_ids,couponResponse.getItem_ids());

    }

    @Test
    void setItem_ids() {

        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448458");
        item_ids.add("MLA670752298");
        item_ids.add("MLA910455609");
        couponResponse.setItem_ids(item_ids);

        Assertions.assertEquals(item_ids,couponResponse.getItem_ids());

    }

    @Test
    void getTotal() {

        float total = 675f;
        Assertions.assertEquals(total,couponResponse.getTotal());

    }

    @Test
    void setTotal() {
        float newTotal = 800f;
        couponResponse.setTotal(newTotal);
        Assertions.assertEquals(newTotal,couponResponse.getTotal());
    }
}