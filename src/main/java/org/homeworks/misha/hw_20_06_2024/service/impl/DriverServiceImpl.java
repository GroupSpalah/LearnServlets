package org.homeworks.misha.hw_20_06_2024.service.impl;

import org.homeworks.misha.hw_20_06_2024.dao.CrudDAO;
import org.homeworks.misha.hw_20_06_2024.dao.impl.DriverDAOImpl;
import org.homeworks.misha.hw_20_06_2024.domain.DriverM;
import org.homeworks.misha.hw_20_06_2024.service.CrudService;

import java.sql.SQLException;

public class DriverServiceImpl implements CrudService<DriverM> {
    private CrudDAO<DriverM> dao;

    public DriverServiceImpl() {
        dao = new DriverDAOImpl();
    }

    @Override
    public void add(DriverM driver) throws SQLException {
        dao.add(driver);

    }


    @Override
    public void update(DriverM driver) throws SQLException {
        dao.update(driver);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        dao.deleteById(id);

    }

    @Override
    public DriverM findById(int id) throws SQLException {
        return dao.findById(id);
    }
}
