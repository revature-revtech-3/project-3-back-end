package com.project3.revtech.controller;

import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.entity.Cart;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.CartPojo;
import com.project3.revtech.service.CartService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
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
public class CartControllerTest {

    @Autowired
    private CartController cartController;

    @Autowired
    private MockMvc mockMvc;

    // "Full authentication is required to access this resource","status":401
    @Test
    public void contextLoads() throws Exception {
        assertThat(cartController).isNotNull();
    }

    // "Full authentication is required to access this resource","status":401
    @Test
    public void addCartUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    // "Full authentication is required to access this resource","status":401
    @Test
    public void updateCartUnauthorizedLoggedInTest() throws  Exception {
        this.mockMvc.perform(get("/put")).andDo(print()).andExpect(status().isUnauthorized());
    }
}
