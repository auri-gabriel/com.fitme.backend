package com.fitme.backend.service;

import com.fitme.backend.entity.Dish;
import com.fitme.backend.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public List<Dish> getByRestaurantId(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }
}
