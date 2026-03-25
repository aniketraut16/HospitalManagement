package com.example.HospitalManagement.apitesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("API Test: findByUnavailable=false should return 200 with room data")
    void testFindByUnavailable_False_ReturnsOk() throws Exception {
        mockMvc.perform(get("/rooms/search/findByUnavailable")
                        .param("unavailable", "false")
                        .param("page", "0")
                        .param("size", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.rooms").isArray())
                .andExpect(jsonPath("$._embedded.rooms[*].unavailable").exists())
                .andExpect(jsonPath("$.page").exists())
                .andExpect(jsonPath("$.page.size").value(5))
                .andExpect(jsonPath("$.page.number").value(0));
    }
    
}
