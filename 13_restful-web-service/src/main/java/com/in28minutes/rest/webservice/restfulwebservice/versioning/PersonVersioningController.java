package com.in28minutes.rest.webservice.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 personV1Param() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 personV2Param() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personV1Header() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personV2Header() {
        return new PersonV2("Bob", "Charlie");
    }
}
