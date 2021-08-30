package com.example.Cupon.responses;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.List;


public class CouponResponse {

        public ArrayList<String> getItem_ids() {
            return item_ids;
        }

        public void setItem_ids(ArrayList<String> item_ids) {
            this.item_ids = item_ids;
        }

        public Float getTotal() {
            return total;
        }

        public void setTotal(Float total) {
            this.total = total;
        }

        private ArrayList<String> item_ids;
        private Float total;

        public CouponResponse(ArrayList<String> item_ids, Float total) {
            this.item_ids = item_ids;
            this.total = total;
        }



}
