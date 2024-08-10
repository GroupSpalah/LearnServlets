package org.homeworks.misha.hw_20_06_2024.service;

import org.homeworks.misha.hw_20_06_2024.domain.TruckM;

import java.sql.SQLException;
import java.util.List;

public interface TruckService extends CrudService<TruckM> {

    List<TruckM> findAllByDriverId(int driverId) throws SQLException;
}
