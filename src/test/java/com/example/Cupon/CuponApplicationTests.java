package com.example.Cupon;

import com.example.Cupon.requestmodels.CouponRequest;
import com.example.Cupon.resources.CouponResource;
import com.example.Cupon.services.CouponService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CuponApplicationTests {

	@Autowired
	private CouponService couponService;



	@Test
	public void exampleTest() throws JSONException, IOException {


	}

}
