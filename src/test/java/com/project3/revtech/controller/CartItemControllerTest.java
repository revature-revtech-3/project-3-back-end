package com.project3.revtech.controller;

import com.project3.revtech.dao.CartItemRepository;
import com.project3.revtech.entity.CartItem;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartItemPojo;
import com.project3.revtech.service.CartItemServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartItemControllerTest {

    @Autowired
    private CartItemController cartItemController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(cartItemController).isNotNull();
    }

    @Test
    public void addItemUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void updateItemUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/put")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void removeItemUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/1/delete")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
