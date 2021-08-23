package com.study.controller;

import com.study.entity.SmartCustomer;
import com.study.repository.SmartCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
public class SmartCustomerController {

    @Autowired
    private SmartCustomerRepository smartCustomerRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<SmartCustomer> findAll(){
        return smartCustomerRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public SmartCustomer findById(@PathVariable("id") Long id){
        return smartCustomerRepository.findById(id);
    }

    @PostMapping("/sava")
    public void findById(SmartCustomer smartCustomer){
        smartCustomerRepository.saveSmartCustomer(smartCustomer);
    }

    @PostMapping("/update")
    public void update(@RequestBody SmartCustomer smartCustomer){
        smartCustomerRepository.saveOrDelete(smartCustomer);
    }

    @PostMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        smartCustomerRepository.deleteSmartCustomerById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前端口：" + port;
    }
}
