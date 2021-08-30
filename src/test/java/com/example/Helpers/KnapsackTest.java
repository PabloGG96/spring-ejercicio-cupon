package com.example.Helpers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Autowired
    private Knapsack knapsack;

    @Test
    void getMaximizedItemsIDByTopWith3Items() {

        //Item 1 = 300
        //Item 2 = 350
        //Item 3 = 270
        //amount = 570
        Knapsack knapsack = new Knapsack();
        List<Integer> response = new ArrayList<Integer>();
        List<Integer> itemsToBuy = new ArrayList<Integer>();
        itemsToBuy.add(0);
        itemsToBuy.add(2);
        int values[] = {300,350,270};
        int amount = 570;

        response = knapsack.getMaximizedItemsIDByTop(amount,values,values);
        Assertions.assertEquals(response,itemsToBuy);

    }

    @Test
    void getMaximizedItemsIDByTopWithInsuficentAmount() {

        //Item 1 = 300
        //Item 2 = 350
        //Item 3 = 270
        //amount = 570
        Knapsack knapsack = new Knapsack();
        List<Integer> response = new ArrayList<Integer>();
        List<Integer> itemsToBuy = new ArrayList<Integer>();
        itemsToBuy.add(0);
        itemsToBuy.add(2);
        int values[] = {300,350,270};
        int amount = 10;

        response = knapsack.getMaximizedItemsIDByTop(amount,values,values);
        Assertions.assertEquals(response.size(),0 );

    }


    @Test
    void getMaximizedItemsIDByTopWithNoItems() {

        //Item 1 = 300
        //Item 2 = 350
        //Item 3 = 270
        //amount = 570
        Knapsack knapsack = new Knapsack();
        List<Integer> response = new ArrayList<Integer>();
        List<Integer> itemsToBuy = new ArrayList<Integer>();
        itemsToBuy.add(0);
        itemsToBuy.add(2);
        int values[] = {};
        int amount = 10;

        response = knapsack.getMaximizedItemsIDByTop(amount,values,values);
        Assertions.assertEquals(response.size(),0 );

    }



}