package org.homeworks.anton.hw_16_06_24.dao;

import org.homeworks.anton.hw_16_06_24.domain.Truck;

import java.sql.SQLException;
import java.util.List;

public interface TruckDao extends CrudDao<Truck> {
 public List<Truck> showByDriver(String name)throws SQLException;
}
