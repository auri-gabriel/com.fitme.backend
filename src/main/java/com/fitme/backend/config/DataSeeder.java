package com.fitme.backend.config;

import com.fitme.backend.entity.Dish;
import com.fitme.backend.entity.DishCategory;
import com.fitme.backend.entity.Restaurant;
import com.fitme.backend.repository.DishCategoryRepository;
import com.fitme.backend.repository.DishRepository;
import com.fitme.backend.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;
    private final DishCategoryRepository categoryRepository;

    public DataSeeder(RestaurantRepository restaurantRepository,
                      DishRepository dishRepository,
                      DishCategoryRepository categoryRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔧 Running DataSeeder...");

        dishRepository.deleteAll();
        categoryRepository.deleteAll();
        restaurantRepository.deleteAll();

        List<Restaurant> restaurants = new ArrayList<>();
        List<DishCategory> allCategories = new ArrayList<>();
        List<Dish> allDishes = new ArrayList<>();

        String[] restaurantNames = {
                "Fit Grub", "Healthy Bites", "Green Delight", "Lean Meals", "NutriBox",
                "Power Kitchen", "Organic Fuel", "Clean Eats", "Veggie Express", "Wholesome Bites"
        };

        String[] locations = {
                "Downtown", "Midtown", "Uptown", "Downtown", "West End",
                "City Center", "Old Town", "Midtown", "East Side", "Suburbia"
        };

        String[] categoryNames = {"Salads", "Wraps", "Bowls"};
        int dishCounter = 1;

        for (int i = 0; i < restaurantNames.length; i++) {
            Restaurant restaurant = Restaurant.builder()
                    .name(restaurantNames[i])
                    .location(locations[i])
                    .rating(4.0 + (i % 5) * 0.1)
                    .deliveryTime(20 + (i % 10))
                    .image("https://example.com/image" + (i + 1) + ".jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            restaurants.add(restaurant);
        }

        restaurantRepository.saveAll(restaurants);

        for (Restaurant restaurant : restaurants) {
            List<DishCategory> categories = new ArrayList<>();

            for (String catName : categoryNames) {
                DishCategory category = DishCategory.builder()
                        .name(catName)
                        .restaurant(restaurant)
                        .build();
                categories.add(category);
            }

            categoryRepository.saveAll(categories);
            allCategories.addAll(categories);

            for (DishCategory category : categories) {
                for (int j = 0; j < 2; j++) {
                    if (dishCounter > 50) break; // Limit to 50 dishes total
                    Dish dish = Dish.builder()
                            .name("Dish " + dishCounter)
                            .price(15.0 + (dishCounter % 10))
                            .image("https://example.com/dish" + dishCounter + ".jpg")
                            .description("Tasty and healthy meal #" + dishCounter)
                            .restaurant(restaurant)
                            .category(category)
                            .build();
                    allDishes.add(dish);
                    dishCounter++;
                }
            }
        }

        dishRepository.saveAll(allDishes);
        System.out.println("✅ Seeded " + restaurants.size() + " restaurants, " + allCategories.size() + " categories, and " + allDishes.size() + " dishes.");
    }
}