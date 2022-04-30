package com.yuriiu28min.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
    public String getUrl() {
        return url;
    }

    @Value("${external.service.url}")
    private String url;
}
