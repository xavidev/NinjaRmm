package com.ninjaone.apps.rmmcustomers.controller.explanation;

import com.ninjaone.rmmcustomers.customerdevcies.application.explanation.CustomerDeviceExplanationQuery;
import com.ninjaone.rmmcustomers.customerdevcies.application.explanation.ExplanationResponse;
import com.ninjaone.shared.domain.DomainException;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public final class CustomerExplanationGetController extends ApiController {
    public CustomerExplanationGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(path = "/explanation/{id}")
    public @ResponseBody ResponseEntity<String> index(
        @PathVariable String id) {
        ExplanationResponse response = ask(new CustomerDeviceExplanationQuery(id));

        return new ResponseEntity<>(response.explanation(), HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        return null;
    }
}
