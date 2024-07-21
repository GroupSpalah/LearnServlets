package org.homeworks.anton.hw_16_06_24.dao;

import org.homeworks.anton.hw_16_06_24.domain.Truck;

public interface CrudDao<T> {
    public void add(T t);
    public void update(T t);
    public void deleteById(int id);
    public T find(int id);
}
