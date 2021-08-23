package com.study.feign;

import com.study.entity.SmartCustomer;
import com.study.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider", fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping("/customer/findAll")
    Collection<SmartCustomer> findAll();

    @GetMapping("/customer/index")
    String index();
}
