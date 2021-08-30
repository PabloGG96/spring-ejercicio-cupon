package com.example.Cupon.services;

import com.example.Cupon.requestmodels.CouponRequest;
import com.example.Cupon.resources.CouponResource;
import com.example.Helpers.Knapsack;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service
public class CouponService {

    @Autowired
    private ItemService itemService;


    public CouponService(ItemService itemService) {
        this.itemService = itemService;
    }

    public CouponResource getFavourites(CouponRequest request) throws JSONException, IOException {

        HashMap <String, Float> items = new LinkedHashMap();
        ArrayList<String> itemsName = new ArrayList<String>(); //Utilizado para almacenar los nombres de los items
        int amountOfItems = request.getItem_ids().size(); //Cantidad de items en favoritos
        int values[] = new int[amountOfItems];     //Vector de valor para Knapsack: utilizado para los precios de los items
        int amount = Math.round(request.getAmount()*100);    //Llevamos al monto a un valor en entero para probar
        float amountToSpend = 0;


        ArrayList<String> itemsToBuy = new ArrayList<String>();


        int i = 0;
        float itemPrice = 0;
        for(String itemName : request.getItem_ids()) {

            //Validamos que el nombre leido no se encuentre ingresado, de estarlo, será un item repetido y NO lo agregaremos para el analisis
            if(!itemsName.contains(itemName)) {
                itemPrice = itemService.getPriceByItemId(itemName);
                itemPrice = itemPrice<0 ? 0 : itemPrice;
                items.put(itemName, itemPrice);
                itemsName.add(itemName);
                values[i] = Math.round((float) itemPrice * 100);
                i++;
            }
        }

        // instantiating the class KnapsackExample
        Knapsack knapObj = new Knapsack();

        //Obtenemos la posición de los elementos que generan la suma maxima entre los precios de los items en favoritos.
        //Para utilizar este metodo reutilizamos el vector values (con los precios) para utilizarlo como vector de pesos
        List<Integer> favouriteItemsSelected = knapObj.getMaximizedItemsIDByTop(amount, values, values);

        if(favouriteItemsSelected == null || favouriteItemsSelected.size()==0)
            return null;

        //Para cada posición retornada, buscaremos el item correspondiente y armaremos el resultado
        String actualItemName;
        for(Integer id : favouriteItemsSelected){
            actualItemName = itemsName.get(id);
            itemsToBuy.add(actualItemName);
            amountToSpend += items.get(actualItemName);
        }

        return new CouponResource(itemsToBuy,amountToSpend);

    }



}
