package com.ninjaone.apps.rmm.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public abstract class ApplicationTestCase {
    @Autowired
    private MockMvc mockMvc;

    public void getRequest(String endpoint, Integer expectedStatusCode, String expectedResponse) throws Exception {
        mockMvc
            .perform(get(endpoint))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().json(expectedResponse));
    }

    public void postRequest(String endpoint, Integer expectedStatusCode) throws Exception {
        mockMvc
            .perform(post(endpoint))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().string(""));
    }

    public void putRequest(String endpoint, Integer expectedStatusCode) throws Exception {
        mockMvc
            .perform(put(endpoint))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().string(""));
    }

    protected void assertRequestWithBody(
        String method,
        String endpoint,
        String body,
        Integer expectedStatusCode
    ) throws Exception {
        mockMvc
            .perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().string(""));
    }
}
