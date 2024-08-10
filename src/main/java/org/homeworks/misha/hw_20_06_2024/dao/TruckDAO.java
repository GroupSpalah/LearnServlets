package org.homeworks.misha.hw_20_06_2024.dao;

import org.homeworks.misha.hw_20_06_2024.domain.TruckM;

import java.sql.SQLException;
import java.util.List;

public interface TruckDAO extends CrudDAO<TruckM> {
    List<TruckM> findByDriverId(int driverId) throws SQLException;
}
