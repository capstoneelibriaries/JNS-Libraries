package capstone.elibraries.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static capstone.elibraries.testhelpers.DataGenerator.randomString;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SearchControllerTest {

    @Autowired
    private MockMvc mvc;

    // Sanity Test
    @Test
    public void contextLoads() throws Exception {
        assertThat(mvc).isNotNull();
    }

//    public void getSearch() {
//    }

    @Test
    public void testGetHomePage() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdSearch() throws Exception {
        this.mvc.perform(get("/search")
                .param("q", randomString(20))
                .param("option", "ads"))
                .andExpect(status().isOk());
    }

    @Test
    public void testBookSearch() throws Exception {
        this.mvc.perform(get("/search")
                .param("q", randomString(20))
                .param("option", "books"))
                .andExpect(status().isOk());
    }

    @Test
    public void testBookSearchWithBadOption() throws Exception {
        this.mvc.perform(get("/search")
                .param("q", randomString(20))
                .param("option", randomString(3)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testBookSearchWithBadQuery() throws Exception {
        this.mvc.perform(get("/search")
                .param("Q", randomString(20))
                .param("option", "ads"))
                .andExpect(status().isBadRequest());
    }
}