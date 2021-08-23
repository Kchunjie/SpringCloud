package com.study.controller;

import com.study.entity.SmartCustomer;
import com.study.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {
    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public Collection<SmartCustomer> findAll(){
      return  feignProviderClient.findAll();
    }

    @GetMapping("/index")
    public String index(){
        return  feignProviderClient.index();
    }

}
