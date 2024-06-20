package org.homeworks.anton.hw_16_06_24.service;

import org.homeworks.anton.hw_16_06_24.domain.Driver;

import java.sql.SQLException;

public interface CrudService <T>{
    public void add(T t) throws SQLException;
    public void update(T t)throws SQLException;
    public void deleteById(int id) throws SQLException;
    public void find(int id)throws SQLException;
}
