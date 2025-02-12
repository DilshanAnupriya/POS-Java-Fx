package com.pos.dao.custom.impl;

import com.pos.dao.custom.CustomerDao;
import com.pos.entity.Customer;

import java.util.Collections;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean create(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Customer find(String s) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return Collections.emptyList();
    }
}
