package com.example.Cupon.services;

import com.example.Cupon.requestmodels.CouponRequest;
import com.example.Cupon.resources.CouponResource;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CouponServiceTest {

    @MockBean
    ItemService itemServiceMock;

    @Autowired
    CouponService couponService;

    @BeforeEach
    void setUp() throws JSONException, IOException {


    itemServiceMock =  Mockito.mock(ItemService.class);
    couponService = new CouponService(itemServiceMock);
    Mockito.when(itemServiceMock.getPriceByItemId("MLA859448457")).thenReturn(353.53f);
    Mockito.when(itemServiceMock.getPriceByItemId("MLA670752297")).thenReturn(320f);
    Mockito.when(itemServiceMock.getPriceByItemId("MLA910455608")).thenReturn(2098f);

    //Generamos 1000 registros para prueba extensa
    System.out.println("Precio seteado en mock");
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getItemsToBuyWith0FavouriteItem() throws JSONException, IOException {

        CouponResource couponResource;
        ArrayList<String> item_ids = new ArrayList<String>();
        Float amount = 2099f;
        CouponRequest couponRequest = new CouponRequest(item_ids,amount);

        //Enviamos la solicitud
        couponResource = couponService.getFavourites(couponRequest);

        Assertions.assertEquals(null,couponResource);
    }


    @Test
    void getItemsToBuyWith1FavouriteItem() throws JSONException, IOException {

        CouponResource couponResource;
        CouponResource correctResource;
        ArrayList<String> item_ids = new ArrayList<String>();
        //item_ids.add("MLA654897743");
        //item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 2099f;
        CouponRequest couponRequest = new CouponRequest(item_ids,amount);

        //Seteamos el resultado correcto
        ArrayList<String> itemsResult = new ArrayList<String>();
        itemsResult.add("MLA910455608");
        Float result = 2098f;
        correctResource = new CouponResource(itemsResult,result);

        //Enviamos la solicitud
        couponResource = couponService.getFavourites(couponRequest);
        Assertions.assertEquals(correctResource.getItem_ids(),couponResource.getItem_ids());
    }


    @Test
    void getItemsToBuyWith3FavouriteItem() throws JSONException, IOException {

        CouponResource couponResource;
        CouponResource correctResource;
        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448457");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 675f;
        CouponRequest couponRequest = new CouponRequest(item_ids,amount);

        //Seteamos el resultado correcto
        ArrayList<String> itemsResult = new ArrayList<String>();
        itemsResult.add("MLA859448457");
        itemsResult.add("MLA670752297");
        Float result = 673.53f;
        correctResource = new CouponResource(itemsResult,result);

        //Enviamos la solicitud
        couponResource = couponService.getFavourites(couponRequest);
        Assertions.assertEquals(correctResource.getItem_ids(),couponResource.getItem_ids());
    }

    @Test
    void getItemsToBuyWith1000FavouriteItem() throws JSONException, IOException {

        CouponResource couponResource;
        CouponResource correctResource;
        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA859448457");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 675f;
        CouponRequest couponRequest = new CouponRequest(item_ids,amount);

        //Seteamos el resultado correcto
        ArrayList<String> itemsResult = new ArrayList<String>();
        itemsResult.add("MLA859448457");
        itemsResult.add("MLA670752297");
        Float result = 673.53f;
        correctResource = new CouponResource(itemsResult,result);

        //Enviamos la solicitud
        couponResource = couponService.getFavourites(couponRequest);
        Assertions.assertEquals(correctResource.getItem_ids(),couponResource.getItem_ids());
    }


}