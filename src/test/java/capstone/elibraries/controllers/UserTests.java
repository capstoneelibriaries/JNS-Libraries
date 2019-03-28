package capstone.elibraries.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTests {

    @Autowired
    private MockMvc mvc;

    // Sanity Test
    @Test
    public void contextLoads() throws Exception {
        assertThat(mvc).isNotNull();
    }

    @Test
    public void testGetRegister() throws Exception {
        this.mvc.perform(get("/register"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testPostRegister() throws Exception {
        this.mvc.perform(post("/register")
                .param("username", "alice")
                .param("email", "alice@email.com")
                .param("phone", "2223334455")
                .param("password", "password123")
                .param("confirmPassword", "password123")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void testRegisterPostMismatchedPasswords() throws Exception{
        this.mvc.perform(post("/register")
                .param("username", "alice")
                .param("email", "alice@email.com")
                .param("phone", "2223334455")
                .param("password", "password123")
                .param("confirmPassword", "password321")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/register?error"));
    }

}
