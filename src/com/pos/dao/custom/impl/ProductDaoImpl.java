package com.pos.dao.custom.impl;

import com.pos.dao.CrudUtil;
import com.pos.dao.custom.ProductDao;
import com.pos.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean create(Product product) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "INSERT INTO product VALUES(?,?,?,?,?,?)",
                product.getProductId(), product.getProductName(),
                product.getProductUnitPrice(), product.getProductQty(),
                product.getProductQr(), product.getProductImg()
        );
    }

    @Override
    public boolean update(Product product) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "UPDATE product SET product_name=?,product_unit_price=?,qty_on_hand=?,qr_code=?,product_image=? WHERE product_id=?",
                product.getProductName(), product.getProductUnitPrice(), product.getProductQty(), product.getProductQr()
                , product.getProductImg(), product.getProductId()
        );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "DELETE product WHERE product_id=?", s
        );
    }

    @Override
    public Product find(String s) throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute(
                "SELECT * FROM product WHERE product_id=?", s
        );
        if (set.next()) {
            return createProduct(set);
        }
        return null;
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute(
                "SELECT * FROM product"
        );
        List<Product> list = new ArrayList<>();
        while (set.next()) {
            list.add(createProduct(set));
        }
        return list;
    }

    private Product createProduct(ResultSet set) throws SQLException, ClassNotFoundException {
        return new Product(
                set.getString(1),
                set.getNString(2),
                set.getDouble(3),
                set.getInt(4),
                set.getBytes(5),
                set.getBytes(6)
        );
    }


}

