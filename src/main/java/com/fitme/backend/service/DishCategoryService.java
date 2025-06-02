package com.fitme.backend.service;

import com.fitme.backend.dto.CreateDishCategoryInput;
import com.fitme.backend.entity.DishCategory;
import com.fitme.backend.entity.Restaurant;
import com.fitme.backend.repository.DishCategoryRepository;
import com.fitme.backend.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishCategoryService {

    private final DishCategoryRepository categoryRepository;
    private final RestaurantRepository restaurantRepository;

    public DishCategory create(CreateDishCategoryInput input) {
        Restaurant restaurant = restaurantRepository.findById(input.restaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        DishCategory category = DishCategory.builder()
                .name(input.name())
                .restaurant(restaurant)
                .build();

        return categoryRepository.save(category);
    }

    public List<DishCategory> getCategoriesByRestaurant(Long restaurantId) {
        return categoryRepository.findByRestaurantId(restaurantId);
    }
}
