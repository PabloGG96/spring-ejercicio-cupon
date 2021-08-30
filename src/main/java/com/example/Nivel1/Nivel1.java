package com.example.Nivel1;

import com.example.Helpers.Knapsack;

import java.util.*;

public class Nivel1 {

    public static void main(String[] args) {


        List<String> items = new ArrayList<String>();

        Map<String, Float> favouriteItems = new LinkedHashMap<>();
        favouriteItems.put("MLA1", 100f);
        favouriteItems.put("MLA2", 210f);
        favouriteItems.put("MLA3", 260f);
        favouriteItems.put("MLA4", 80f);
        favouriteItems.put("MLA5", 90f );
        float amount = 500f;

        items = calculate(favouriteItems,amount);
        iterateAndShowArrayList(items);

    }


    public static List<String> calculate(Map<String, Float> items, float amount){

        List<String> itemsName = new ArrayList<String>();
        List<String> itemsResult = new ArrayList<String>();

        //Inicialización de variables:
        Map<String, Float> favouriteItems = items; //Para no utilizar el elemento recibido por parametro
        int amountOfItems = favouriteItems.size(); //Cantidad de items en favoritos
        int values[] = new int[amountOfItems];     //Vector de valor para Knapsack: utilizado para los precios de los items
        int weight[] = new int[amountOfItems] ;     //Vector de pesos para Knapsack
        int capacity = Math.round(amount*10);   //Llevamos al monto a un valor en entero para probar

        int i = 0;
        Iterator it = favouriteItems.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();
            values[i] = Math.round((float)pair.getValue()*10);
            weight[i] = Math.round((float)pair.getValue()*10);
            itemsName.add((String) pair.getKey().toString());
            i++;
        }

        // instantiating the class KnapsackExample
        Knapsack knapObj = new Knapsack();

        //Obtenemos la posición de los elementos que generan la suma maxima entre los precios de los items en favoritos
        List<Integer> favouriteItemsSelected = knapObj.getMaximizedItemsIDByTop(capacity, weight, values);

        float sum = 0;
        for(Integer id : favouriteItemsSelected){
            itemsResult.add(itemsName.get(id));
            sum += items.get(itemsName.get(id));
        }

        /*
        for (String text: itemsResult){
            System.out.println(text);
        }

        System.out.println(sum);*/

        return itemsResult;
    }

    public static void iterateAndShowArrayList(List<String> arraylist){
        for(String Item : arraylist){
            System.out.println(Item);
        }

    }

}
