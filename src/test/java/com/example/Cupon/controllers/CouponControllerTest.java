package com.example.Cupon.controllers;

import com.example.Cupon.requestmodels.CouponRequest;
import com.example.Cupon.resources.CouponResource;
import com.example.Cupon.responses.CouponResponse;
import com.example.Cupon.services.CouponService;
import com.example.Cupon.services.ItemService;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CouponControllerTest {

    @MockBean
    CouponService couponServiceMock = Mockito.mock(CouponService.class);

    @Autowired
    CouponController couponController;

    @Autowired
    CouponRequest couponRequest;

    @Autowired
    CouponResource serviceResponse;


    @BeforeEach
    void setUp() throws JSONException, IOException {

        couponServiceMock = Mockito.mock(CouponService.class);
        couponController = new CouponController(couponServiceMock);

        //Entidad a validar
        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA654897743");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 2099f;
        couponRequest = new CouponRequest(item_ids,amount);

        //Establecemos el resultado
        ArrayList<String> itemsResult = new ArrayList<String>();
        itemsResult.add("MLA910455608");
        Float result = 2098f;
        serviceResponse = new CouponResource(itemsResult,result);

        Mockito.when(couponServiceMock.getFavourites(couponRequest)).thenReturn(serviceResponse);


    }

    @AfterEach
    void tearDown() {
    }



    @Test
    @Ignore
    void calculateWithCorrectRequest() {
        ArrayList<String> item_ids = new ArrayList<String>();
        item_ids.add("MLA654897743");
        item_ids.add("MLA670752297");
        item_ids.add("MLA910455608");
        Float amount = 2099f;
        couponRequest = new CouponRequest(item_ids,amount);

        ResponseEntity<CouponResponse> response = couponController.calculate(couponRequest);

        Assertions.assertEquals(HttpStatus.OK,response);

    }


    @Test
    void calculateWithEmptyItemList() {
        ArrayList<String> item_ids = new ArrayList<String>();
        Float amount = 2099f;
        couponRequest = new CouponRequest(item_ids,amount);

        ResponseEntity<CouponResponse> response = couponController.calculate(couponRequest);
        ResponseEntity<CouponResponse> expectedResponse = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        Assertions.assertEquals(expectedResponse,response);

    }

}