package com.fitme.backend.repository;

import com.fitme.backend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByRestaurantId(Long restaurantId);

}
