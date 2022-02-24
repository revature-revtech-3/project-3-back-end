package com.project3.revtech.controller;

import com.project3.revtech.dao.TransactionRepository;
import com.project3.revtech.entity.Transaction;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.TransactionPojo;
import com.project3.revtech.service.TransactionService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private TransactionController transactionController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void contextLoads() throws Exception {
        assertThat(transactionController).isNotNull();
    }

    //getTransactionById Constructor Test
    @Test
    public void shouldReceiveTheTransactionIdTest() throws Exception {
        this.mockMvc.perform(get("/10/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //getCartTransaction Constructor Test
    @Test
    public void gettingCartTransactionByCardIdUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/cart/1/get")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //createTransaction Constructor Test
    @Test
    public void creatingTransactionPostUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //UpdateTransaction Constructor Test
    @Test
    public void updateTransactionPutUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/put")).andDo(print()).andExpect(status().isUnauthorized());
    }

    //deleteTransaction Constructor Test
    @Test
    public void deleteTransactionUnauthorizedLoggedInTest() throws Exception {
        this.mockMvc.perform(get("/transaction/delete")).andDo(print()).andExpect(status().isUnauthorized());
    }

}
