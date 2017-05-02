package ua.com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.furniture.entity.Commodity;
import ua.com.furniture.service.CommodityService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(CommodityController.URL)
public class CommodityController {
    static final String URL = "/api/commodity";

    @Autowired
    private CommodityService commodityService;

    @GetMapping
    public List<Commodity> get() {
        return commodityService.findAll();
    }

    @PostMapping
    public Commodity save(@RequestBody Commodity commodity) {
        return commodityService.save(commodity);
    }

    @PutMapping
    public Commodity update(@RequestBody Commodity commodity) {
        return commodityService.save(commodity);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        commodityService.delete(id);
    }
}
