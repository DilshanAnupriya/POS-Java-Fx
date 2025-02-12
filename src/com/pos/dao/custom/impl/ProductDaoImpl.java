package com.pos.dao.custom.impl;

import com.pos.dao.custom.ProductDao;
import com.pos.entity.Product;

import java.util.Collections;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Product find(String s) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return Collections.emptyList();
    }
}
