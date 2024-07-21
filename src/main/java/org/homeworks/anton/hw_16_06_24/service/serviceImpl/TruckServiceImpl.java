package org.homeworks.anton.hw_16_06_24.service.serviceImpl;

import org.homeworks.anton.hw_16_06_24.dao.TruckDao;
import org.homeworks.anton.hw_16_06_24.dao.impl.TruckDaoImpl;
import org.homeworks.anton.hw_16_06_24.domain.Truck;
import org.homeworks.anton.hw_16_06_24.service.TruckService;

import java.sql.SQLException;
import java.util.List;


public class TruckServiceImpl implements TruckService {
    TruckDao dao;
    public TruckServiceImpl() { dao = new TruckDaoImpl(); }

    public List<Truck> showByDriver(int id) throws SQLException {
return  dao.showByDriver(id);
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
    public void deleteById(int id) throws SQLException {
        dao.deleteById(id);
    }


    @Override
    public Truck find(int id) throws SQLException {
return  dao.find(id);


    }
}
