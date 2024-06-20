package org.homeworks.anton.hw_16_06_24.service.serviceImpl;

import org.homeworks.anton.hw_16_06_24.dao.TruckDao;
import org.homeworks.anton.hw_16_06_24.dao.impl.TruckDaoImpl;
import org.homeworks.anton.hw_16_06_24.domain.Driver;
import org.homeworks.anton.hw_16_06_24.domain.Truck;
import org.homeworks.anton.hw_16_06_24.service.TruckService;

import java.sql.SQLException;


public class TruckServiceImpl implements TruckService {
    TruckDao dao;
    public TruckServiceImpl() { dao = new TruckDaoImpl(); }

    public void showByDriver(String name) throws SQLException {
dao.showByDriver(name);
    }


    @Override
    public void add(Truck truck) throws SQLException {
dao.add(truck);
    }

    @Override
    public void update(Truck truck) throws SQLException {
dao.update(truck);
    }

    @Override
    public void delete(Truck truck) throws SQLException {
dao.delete(truck);
    }

    @Override
    public Driver find(int id) throws SQLException {
dao.find(id);
        return null;
    }
}
