package com.ninjaone.apps;

import com.ninjaone.shared.domain.bus.command.Command;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import com.ninjaone.shared.domain.bus.event.DomainEvent;
import com.ninjaone.shared.domain.bus.event.EventBus;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ApplicationTestCase {

    protected final int BAD_REQUEST = 400;

    protected final int CONFLICT = 409;
    protected final int CREATED = 201;

    protected final int OK = 200;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventBus eventBus;

    @Autowired
    private CommandBus commandBus;

    public void getRequest(String endpoint, Integer expectedStatusCode, String expectedResponse) throws Exception {
        mockMvc
            .perform(get(endpoint))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().json(expectedResponse));
    }

    public void getRequestStringContent(String endpoint, Integer expectedStatusCode, String expectedResponse) throws Exception {
        mockMvc
            .perform(get(endpoint))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().string(expectedResponse));
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

    protected void assertResponseWithBody(
        String method,
        String endpoint,
        String body,
        Integer expectedStatusCode,
        String expectedContent
    ) throws Exception {
        mockMvc
            .perform(request(HttpMethod.valueOf(method), endpoint).content(body).contentType(APPLICATION_JSON))
            .andExpect(status().is(expectedStatusCode))
            .andExpect(content().string(expectedContent));
    }

    protected void givenISendEventsToTheBus(DomainEvent... domainEvents) {
        eventBus.publish(Arrays.asList(domainEvents));
    }

    protected void givenISendCommandToTheBus(Command command) {
        commandBus.dispatch(command);
    }
}
