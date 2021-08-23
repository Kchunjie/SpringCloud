package com.study.repository.impl;

import com.study.entity.SmartCustomer;
import com.study.repository.SmartCustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SmartCustomerRepositoryImpl implements SmartCustomerRepository {

    private static Map<Long, SmartCustomer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1L, new SmartCustomer(1L, "张三", 1));
        customerMap.put(2L, new SmartCustomer(2L, "王五", 1));
        customerMap.put(3L, new SmartCustomer(3L, "李四", 1));
    }

    @Override
    public Collection<SmartCustomer> findAll() {
        return customerMap.values();
    }

    @Override
    public SmartCustomer findById(Long id) {
        return customerMap.get(id);
    }

    @Override
    public int saveSmartCustomer(SmartCustomer smartCustomer) {
        customerMap.put(smartCustomer.getId(), smartCustomer);
        return 1;
    }

    @Override
    public int deleteSmartCustomerById(Long id) {
        customerMap.remove(id);
        return 1;
    }

    @Override
    public void saveOrDelete(SmartCustomer smartCustomer) {
        customerMap.put(smartCustomer.getId(), smartCustomer);
    }
}
