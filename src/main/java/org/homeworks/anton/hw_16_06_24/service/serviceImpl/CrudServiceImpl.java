package org.homeworks.anton.hw_16_06_24.service.serviceImpl;

import org.homeworks.anton.hw_16_06_24.dao.CrudDao;
import org.homeworks.anton.hw_16_06_24.dao.impl.DriverDaoImpl;
import org.homeworks.anton.hw_16_06_24.domain.Driver;
import org.homeworks.anton.hw_16_06_24.domain.Truck;
import org.homeworks.anton.hw_16_06_24.service.CrudService;

import java.sql.SQLException;

public class CrudServiceImpl implements CrudService<Driver> {

    CrudDao<Driver> dao;
 public CrudServiceImpl() {dao = new DriverDaoImpl();
 }

    @Override
    public void add(Driver driver) throws SQLException {
dao.add(driver);
    }

    @Override
    public void update(Driver driver) throws SQLException {
dao.update(driver);
    }

    @Override
    public void deleteById(int id) throws SQLException {
dao.deleteById(id);
    }

    @Override
    public Driver find(int id) throws SQLException {
         return  dao.find(id);
 }
}
