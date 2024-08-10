package org.homeworks.misha.hw_20_06_2024.service.impl;

import org.homeworks.misha.hw_20_06_2024.dao.TruckDAO;
import org.homeworks.misha.hw_20_06_2024.dao.impl.TruckDAOImpl;
import org.homeworks.misha.hw_20_06_2024.domain.TruckM;
import org.homeworks.misha.hw_20_06_2024.service.TruckService;

import java.sql.SQLException;
import java.util.List;

public class TruckServiceImpl implements TruckService {
    private TruckDAO dao;

    public TruckServiceImpl() {
        dao = new TruckDAOImpl();

    }


    @Override
    public void update(TruckM truck) throws SQLException {
        dao.update(truck);

    }

    @Override
    public void deleteById(int id) throws SQLException {
        dao.deleteById(id);

    }

    @Override
    public void add(TruckM truck) throws SQLException {
        dao.add(truck);

    }

    @Override
    public TruckM findById(int id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public List<TruckM> findAllByDriverId(int driverId) throws SQLException {
        return dao.findByDriverId(driverId);
    }
}
