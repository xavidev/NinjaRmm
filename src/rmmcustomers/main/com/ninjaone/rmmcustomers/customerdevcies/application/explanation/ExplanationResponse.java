package com.ninjaone.rmmcustomers.customerdevcies.application.explanation;

import com.ninjaone.shared.domain.bus.query.Response;

public final class ExplanationResponse implements Response {
    private final String explanation;

    public ExplanationResponse(String explanation) {

        this.explanation = explanation;
    }

    public String explanation(){
        return explanation;
    }
}
