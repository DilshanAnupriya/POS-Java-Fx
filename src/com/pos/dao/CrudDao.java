package com.pos.dao;

import com.pos.entity.SuperEntity;

import java.util.List;

public interface CrudDao<T extends SuperEntity,ID>  extends SuperDao{
    public  boolean create(T t);
    public  boolean update(T t);
    public  boolean delete(ID id);
    public T find(ID id);
    public List<T> findAll();
}
