package com.fitme.backend.config;

import com.fitme.backend.entity.Dish;
import com.fitme.backend.entity.Restaurant;
import com.fitme.backend.repository.DishRepository;
import com.fitme.backend.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public DataSeeder(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔧 Running DataSeeder...");
        restaurantRepository.deleteAll();
        dishRepository.deleteAll();

        if (restaurantRepository.count() == 0) {
            Restaurant r1 = Restaurant.builder()
                    .name("Fit Grub")
                    .location("Downtown")
                    .rating(4.5)
                    .build();

            Restaurant r2 = Restaurant.builder()
                    .name("Healthy Bites")
                    .location("Midtown")
                    .rating(4.2)
                    .build();

            restaurantRepository.saveAll(List.of(r1, r2));

            Dish d1 = Dish.builder()
                    .name("Grilled Chicken Salad")
                    .price(25.0)
                    .image("https://example.com/salad.jpg")
                    .description("High-protein chicken with fresh greens")
                    .restaurant(r1)
                    .build();

            Dish d2 = Dish.builder()
                    .name("Avocado Toast")
                    .price(18.5)
                    .image("https://example.com/avocado.jpg")
                    .description("Whole grain toast with smashed avocado")
                    .restaurant(r1)
                    .build();

            Dish d3 = Dish.builder()
                    .name("Quinoa Bowl")
                    .price(22.0)
                    .image("https://example.com/quinoa.jpg")
                    .description("Quinoa with roasted veggies and hummus")
                    .restaurant(r2)
                    .build();

            dishRepository.saveAll(List.of(d1, d2, d3));

            System.out.println("Sample restaurants and dishes inserted!");
        }
    }
}
