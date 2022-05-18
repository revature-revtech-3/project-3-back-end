package com.project3.revtech.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.project3.revtech.pojo.CartPojo;

@SpringBootTest
@AutoConfigureMockMvc
public class EmailControllerTest {
	
	@Autowired
	private EmailController emailController;
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoadsHPath() throws Exception {
        assertThat(emailController).isNotNull();
    }
 
    @Test
    public void emailNotificationPositiveTest() throws Exception {
    
    	 this.mockMvc.perform(post("/api/notification/{id}/post", 1))
    	         
        String email = emailRepository.getEmail(userId);
		emailServiceImpl.sendMessage(email, null, null);
                
                
                 mockMvc.perform(MockMvcRequestBuilders.post("/api/notification/{id}/post")
    }
    
   
    
 
  //------------------------NEGATIVE TEST--------------------------  
    /*
    private EmailController emailController2;
    
    @Test
    public void contextLoadsSPath() throws Exception {
        assertThat(emailController2).isNotNull();
    }*/
    
}
