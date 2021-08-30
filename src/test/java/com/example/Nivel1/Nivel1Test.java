package com.example.Nivel1;

import com.example.Cupon.CuponApplication;
import com.example.Helpers.Knapsack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.example.Nivel1.Nivel1.calculate;
import static org.junit.jupiter.api.Assertions.*;

class Nivel1Test {

    @Autowired
    private Knapsack knapsack;

    @Test
    void calculateWithFiveItems() {

        List<String> items = new ArrayList<String>();

        Map<String, Float> favouriteItems = new LinkedHashMap<>();
        favouriteItems.put("MLA1", 100f);
        favouriteItems.put("MLA2", 210f);
        favouriteItems.put("MLA3", 260f);
        favouriteItems.put("MLA4", 80f);
        favouriteItems.put("MLA5", 90f );
        float amount = 500f;

        //Result
        List<String> result = new ArrayList<String>();
        result.add("MLA1");
        result.add("MLA2");
        result.add("MLA4");
        result.add("MLA5");


        items = calculate(favouriteItems,amount);
        Assertions.assertEquals(items,result);



    }

    @Test
    void iterateAndShowArrayList() {

        List<String> result = new ArrayList<String>();
        result.add("MLA1");
        result.add("MLA2");
        result.add("MLA4");
        result.add("MLA5");

        for(String Item : result){
            System.out.println(Item);
        }
    }

    @Test
    void main() {
        Nivel1.main(new String[]{});
    }
}