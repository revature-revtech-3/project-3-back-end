package com.project3.revtech.controller;

import com.project3.revtech.dao.CartRepository;
import com.project3.revtech.dao.CartItemRepository;
import com.project3.revtech.controller.TestController;
import com.project3.revtech.entity.User;
import com.project3.revtech.entity.Cart;
import com.project3.revtech.entity.CartItem;
import com.project3.revtech.joinedPojo.CartAndItemsPojo;
import com.project3.revtech.service.CartItemProductServiceImpl;
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
public class TestControllerTest {

    @Autowired
    private TestController testController;


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void contextLoads() throws Exception {
        assertThat(testController).isNotNull();
    }

    @Test
    public void allAccessTest() throws  Exception {
        this.mockMvc.perform(get("/all")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void userAccessTest() throws Exception {
        this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void moderatorAccessTest() throws Exception {
        this.mockMvc.perform(get("/mod")).andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    public void adminAccessTest() throws Exception {
        this.mockMvc.perform(get("/admin")).andDo(print()).andExpect(status().isUnauthorized());
    }

}
