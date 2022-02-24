package com.project3.revtech.controller;

import org.junit.jupiter.api.Test;
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
public class DiscountControllerTest {

    @Autowired
    private DiscountController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotReturnGetAllDiscountsUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/all/discounts")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotPostNewDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/add/discounts")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotDeleteDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/remove/discounts/1")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //"Full authentication is required to access this resource","status":401
    @Test
    public void shouldNotUpdateDiscountUnauthorizedNotLoggedIn() throws Exception {
        this.mockMvc.perform(get("/update/discounts")).andDo(print()).andExpect(status().isUnauthorized());
    }

}
