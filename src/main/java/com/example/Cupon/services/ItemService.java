package com.example.Cupon.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ItemService {


    protected float getPriceByItemId(String itemName) throws IOException, JSONException {

        float itemPrice =0;

        URL url = new URL("https://api.mercadolibre.com/items/"+itemName);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept","application/json");
        con.setRequestProperty("Accept-Charset", "UTF-8");
        con.setRequestProperty("Transfer-Encoding","chunked");
        //con.setRequestProperty("Content-Encoding","UTF-8");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        JSONObject result = new JSONObject(content.toString());
        itemPrice = (float) result.getDouble("price");

        in.close();

        con.disconnect();


        return itemPrice;


    }



}
