package com.fitme.backend.repository;

import com.fitme.backend.entity.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {
    List<DishCategory> findByRestaurantId(Long restaurantId);
}