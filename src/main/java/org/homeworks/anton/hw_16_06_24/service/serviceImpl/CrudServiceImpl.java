package org.homeworks.anton.hw_16_06_24.service.serviceImpl;

import org.homeworks.anton.hw_16_06_24.dao.CrudDao;
import org.homeworks.anton.hw_16_06_24.domain.Driver;
import org.homeworks.anton.hw_16_06_24.service.CrudService;

import java.sql.SQLException;

public class CrudServiceImpl implements CrudService<Driver> {

    CrudDao<Driver> dao;


    @Override
    public void add(Driver driver) throws SQLException {
dao.add(driver);
    }

    @Override
    public void update(Driver driver) throws SQLException {
dao.update(driver);
    }

    @Override
    public void delete(Driver driver) throws SQLException {
dao.delete(driver);
    }

    @Override
    public Driver find(int id) throws SQLException {
dao.find(id);
        return null;
    }
}
