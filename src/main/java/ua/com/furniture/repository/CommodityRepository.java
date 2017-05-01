package ua.com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.furniture.entity.Commodity;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
}
