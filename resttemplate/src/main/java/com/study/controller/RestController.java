package com.study.controller;

import com.study.entity.SmartCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection findAll(){

        return restTemplate.getForEntity("http://localhost:8010/customer/findAll", Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection findAll2(){
        return restTemplate.getForObject("http://localhost:8010/customer/findAll", Collection.class);
    }

    @GetMapping("/findById/{id}")
    public SmartCustomer findById(@PathVariable("id") Long id){
        return restTemplate.getForEntity("http://localhost:8010/customer/findById/{id}",SmartCustomer.class, id).getBody();

    }

    @GetMapping("/findById2/{id}")
    public SmartCustomer findById2(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:8010/customer/findById/{id}",SmartCustomer.class, id);
    }

    @PostMapping("/save")
    public void save(@RequestBody SmartCustomer smartCustomer){
        restTemplate.postForEntity("http://localhost:8010/customer/save/", smartCustomer, null).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody SmartCustomer smartCustomer){
        restTemplate.postForObject("http://localhost:8010/customer/save/", smartCustomer, null);
    }

    @PostMapping("/update")
    public void update(@RequestBody SmartCustomer smartCustomer){
        restTemplate.put("http://localhost:8010/customer/update", smartCustomer);
    }

    @DeleteMapping("/delect/{id}")
    public void deleteById(@PathVariable("id") Long id){
        restTemplate.delete("http://localhost:8010/customer/deleteById/{id}", id);
    }
}
