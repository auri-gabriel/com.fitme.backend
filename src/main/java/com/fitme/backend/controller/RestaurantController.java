package com.fitme.backend.controller;

import com.fitme.backend.dto.CreateRestaurantInput;
import com.fitme.backend.entity.Dish;
import com.fitme.backend.entity.Restaurant;
import com.fitme.backend.service.DishService;
import com.fitme.backend.service.RestaurantService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RestaurantController {

    final private RestaurantService restaurantService;
    private final DishService dishService;

    public RestaurantController(RestaurantService restaurantService, DishService dishService) {
        this.restaurantService = restaurantService;
        this.dishService = dishService;
    }

    @QueryMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAll();
    }

    @MutationMapping
    public Restaurant createRestaurant(@Argument CreateRestaurantInput input) {
        Restaurant restaurant = Restaurant.builder()
                .name(input.name())
                .rating(input.rating())
                .location(input.location())
                .build();
        return restaurantService.save(restaurant);
    }

    @QueryMapping
    public Restaurant getRestaurant(@Argument Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @SchemaMapping(typeName = "Restaurant", field = "topDishes")
    public List<Dish> getTopDishes(Restaurant restaurant) {
        return dishService.getByRestaurantId(restaurant.getId());
    }
}
