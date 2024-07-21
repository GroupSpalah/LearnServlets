package org.homeworks.anton.hw_16_06_24.service;

import org.homeworks.anton.hw_16_06_24.domain.Truck;

import java.sql.SQLException;
import java.util.List;

public interface TruckService extends CrudService<Truck> {
    public List<Truck> showByDriver(int id) throws SQLException;
}
