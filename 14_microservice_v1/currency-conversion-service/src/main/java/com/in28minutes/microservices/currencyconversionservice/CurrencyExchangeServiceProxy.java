package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service") // Direct call to the service
@FeignClient(name = "netflix-zuul-api-gateway-server") // Call through api gateway
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    //@GetMapping("/currency-exchange/from/{from}/to/{to}") // Direct call
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // Call through Api gateway
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
