package com.pos.dao.custom.impl;

import com.pos.dao.CrudUtil;
import com.pos.dao.custom.ProductDao;
import com.pos.entity.Product;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean create(Product product) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "INSERT INTO product VALUES(?,?,?,?,?,?)",
                product.getProductId(),product.getProductName(),
                product.getProductUnitPrice(),product.getProductQty(),
                product.getProductQr(),product.getProductImg()
        );
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "UPDATE product SET product_name=?,product_unit_price=?,qty_on_hand=?,qr_code=?,product_image=? WHERE product_id=?",
                product.getProductName(),product.getProductUnitPrice(),product.getProductQty(),product.getProductQr()
                ,product.getProductImg(),product.getProductId()
        );
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
