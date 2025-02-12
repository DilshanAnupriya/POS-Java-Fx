package com.pos.dao.custom.impl;

import com.pos.dao.CrudUtil;
import com.pos.dao.custom.CustomerDao;
import com.pos.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean create(Customer customer) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute(
                "INSERT INTO customer VALUES(?,?,?,?)",
                customer.getCustomerId(),customer.getCustomerName(),
                customer.getCustomerAddress(),customer.getCustomerSalary()
        );
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
       return CrudUtil.execute(
                "UPDATE customer SET customer_name=?,customer_address=?,customer_salary=? WHERE customer_id=?",
                customer.getCustomerName(),customer.getCustomerAddress()
                ,customer.getCustomerSalary(),customer.getCustomerId()
        );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute(
                "DELETE customer WHERE customer_id=?",s
        );
    }

    @Override
    public Customer find(String s) throws SQLException, ClassNotFoundException {
       ResultSet set = CrudUtil.execute(
                "SELECT * FROM customer WHERE customer_id=?",s
        );
        if (set.next()) {
            return createCustomer(set);
        }
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        ResultSet set = CrudUtil.execute(
                "SELECT * FROM customer"
        );
        List<Customer> list = new ArrayList<>();
        while (set.next()) {
            list.add(createCustomer(set));
        }
        return list;
    }
    private Customer createCustomer(ResultSet set) throws SQLException, ClassNotFoundException {
        return new Customer(
                set.getString(1),
                set.getString(2),
                set.getString(3),
                set.getDouble(4)
        );
    }


}
