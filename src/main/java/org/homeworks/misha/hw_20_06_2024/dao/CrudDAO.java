package org.homeworks.misha.hw_20_06_2024.dao;

import java.sql.SQLException;

public interface CrudDAO<T> {
    void add(T t) throws SQLException;

    void update(T t) throws SQLException;

    void deleteById(int id) throws SQLException;

    T findById(int id) throws SQLException;

}
