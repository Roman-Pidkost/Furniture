package ua.com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.furniture.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
