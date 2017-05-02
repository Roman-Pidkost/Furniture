package ua.com.furniture.service;

import ua.com.furniture.entity.Commodity;

import java.util.List;

public interface CommodityService {
    Commodity save(Commodity commodity);
    List<Commodity> findAll();
    Commodity findOne(int id);
    void delete(int id);
}

