package ua.com.furniture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.furniture.entity.Commodity;
import ua.com.furniture.repository.CommodityRepository;
import ua.com.furniture.repository.SubcategoryRepository;
import ua.com.furniture.service.CommodityService;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public Commodity save(Commodity commodity) {
        return commodityRepository.saveAndFlush(commodity);
    }

    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    public Commodity findOne(int id) {
        return commodityRepository.findOne(id);
    }

    public void delete(int id) {
        commodityRepository.delete(id);
    }
}
