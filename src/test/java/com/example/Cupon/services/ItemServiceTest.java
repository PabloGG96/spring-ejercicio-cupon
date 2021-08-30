package com.example.Cupon.services;

import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    @MockBean
    ItemService itemServiceMock;

    @BeforeEach
    void setUp() throws JSONException, IOException {

        itemServiceMock = Mockito.mock(ItemService.class);
        Mockito.when(itemServiceMock.getPriceByItemId("MLA670752297")).thenReturn(320f);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPriceByItemId() throws JSONException, IOException {

        float result = itemServiceMock.getPriceByItemId("MLA670752297");
        Assertions.assertEquals(320f,result);

    }
}