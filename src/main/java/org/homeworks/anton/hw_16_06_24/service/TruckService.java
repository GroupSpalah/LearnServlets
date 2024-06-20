package org.homeworks.anton.hw_16_06_24.service;

import org.homeworks.anton.hw_16_06_24.domain.Truck;

import java.sql.SQLException;

public interface TruckService extends CrudService<Truck> {
    public void showByDriver(String name) throws SQLException;
}
