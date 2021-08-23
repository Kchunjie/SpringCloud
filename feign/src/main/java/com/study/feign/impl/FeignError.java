package com.study.feign.impl;

import com.study.entity.SmartCustomer;
import com.study.feign.FeignProviderClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<SmartCustomer> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务维护中....";
    }
}
