package com.example.Cupon.controllers;

import com.example.Cupon.requestmodels.CouponRequest;
import com.example.Cupon.resources.CouponResource;
import com.example.Cupon.responses.CouponResponse;
import com.example.Cupon.services.CouponService;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponservice;

    public CouponController(CouponService couponservice) {
        this.couponservice = couponservice;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CouponResponse> calculate (@RequestBody CouponRequest request){

        CouponResponse controllerResponse = null;
        CouponResource serviceResponse = null;
        try {
            serviceResponse = couponservice.getFavourites(request);

            if(serviceResponse!=null)
            controllerResponse = new CouponResponse(serviceResponse.getItem_ids(),serviceResponse.getAmount());
            else
                controllerResponse = null;

        } catch (JSONException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(controllerResponse !=null)
            return new ResponseEntity<>(controllerResponse, HttpStatus.OK) ;
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND) ;
    }


}