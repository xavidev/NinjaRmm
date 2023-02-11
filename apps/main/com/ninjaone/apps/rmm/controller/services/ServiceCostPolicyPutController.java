package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.rmm.services.application.assigncost.AssignServiceCostPolicyCommand;
import com.ninjaone.rmm.services.domain.InvalidCostPolicyException;
import com.ninjaone.rmm.services.domain.MalFormedCostPolicyException;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.shared.domain.DomainException;
import com.ninjaone.shared.domain.Utils;
import com.ninjaone.shared.domain.bus.command.CommandBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.infrastructure.spring.ApiController;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class ServiceCostPolicyPutController extends ApiController {

    public ServiceCostPolicyPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/services/{id}/cost")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody ServiceCostRequest request) {

        dispatch(new AssignServiceCostPolicyCommand(id, request.getType(), Utils.jsonEncode(request.getValue())));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainException>, HttpStatus> errorMapping() {
        HashMap<Class<? extends DomainException>, HttpStatus> errors = new HashMap<>();
        errors.put(ServiceNotExistException.class, HttpStatus.BAD_REQUEST);
        errors.put(InvalidCostPolicyException.class, HttpStatus.BAD_REQUEST);
        errors.put(MalFormedCostPolicyException.class, HttpStatus.BAD_REQUEST);

        return errors;
    }
}

@Data
final class ServiceCostRequest {
    private String type;

    private HashMap<String, Serializable> value;
}
