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
import java.util.Map;

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

        Map<String, String> dishData = Map.ofEntries(
                Map.entry("Quinoa Power Bowl", "A nutritious bowl packed with quinoa, veggies, and lean protein."),
                Map.entry("Avocado Chicken Wrap", "Wrap filled with creamy avocado, grilled chicken, and greens."),
                Map.entry("Kale Caesar Salad", "A healthy twist on a classic Caesar with fresh kale and parmesan."),
                Map.entry("Tofu Teriyaki Bowl", "Tofu glazed in teriyaki over a bed of rice and steamed vegetables."),
                Map.entry("Turkey Spinach Wrap", "A lean and flavorful wrap with turkey, spinach, and hummus."),
                Map.entry("Chickpea Buddha Bowl", "Chickpeas, brown rice, and roasted veggies for a hearty meal."),
                Map.entry("Greek Yogurt Salad", "A light salad with Greek yogurt dressing and fresh cucumbers."),
                Map.entry("Spicy Lentil Wrap", "Lentils, hot spices, and greens wrapped in a whole wheat tortilla."),
                Map.entry("Sweet Potato Bowl", "Roasted sweet potatoes with kale, beans, and tahini sauce."),
                Map.entry("Grilled Chicken Caesar", "Grilled chicken served over crispy romaine with Caesar dressing."),
                Map.entry("Smoky Tempeh Bowl", "Tempeh cubes in a smoky sauce with beans and quinoa.")
        );

        int dishCounter = 0;
        List<String> dishNames = new ArrayList<>(dishData.keySet());

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
                    if (dishCounter >= dishNames.size()) break;

                    String name = dishNames.get(dishCounter);
                    String description = dishData.get(name);

                    Dish dish = Dish.builder()
                            .name(name)
                            .description(description)
                            .price(15.0 + (dishCounter % 10))
                            .image("https://example.com/dish" + (dishCounter + 1) + ".jpg")
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