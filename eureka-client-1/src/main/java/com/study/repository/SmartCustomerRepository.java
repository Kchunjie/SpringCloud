package com.study.repository;

import com.study.entity.SmartCustomer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.util.Collection;


public interface SmartCustomerRepository {

    Collection<SmartCustomer>  findAll ();

    SmartCustomer findById(Long id);

    int saveSmartCustomer(SmartCustomer smartCustomer);

    int deleteSmartCustomerById(Long id);

    void saveOrDelete(SmartCustomer smartCustomer);
}
