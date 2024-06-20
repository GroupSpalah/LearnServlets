package org.homeworks.anton.hw_16_06_24.dao;

public interface CrudDao<T> {
    public void add(T t);
    public void update(T t);
    public void deleteById(int id);
    public void find(int id);
}
