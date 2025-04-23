package com.fitme.backend.config;

import com.fitme.backend.entity.Dish;
import com.fitme.backend.entity.Restaurant;
import com.fitme.backend.repository.DishRepository;
import com.fitme.backend.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
                    .deliveryTime(30)
                    .image("https://example.com/fitgrub.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r2 = Restaurant.builder()
                    .name("Healthy Bites")
                    .location("Midtown")
                    .rating(4.2)
                    .deliveryTime(25)
                    .image("https://example.com/healthybites.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r3 = Restaurant.builder()
                    .name("Green Delight")
                    .location("Uptown")
                    .rating(4.3)
                    .deliveryTime(20)
                    .image("https://example.com/greendelight.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r4 = Restaurant.builder()
                    .name("Lean Meals")
                    .location("Downtown")
                    .rating(4.4)
                    .deliveryTime(35)
                    .image("https://example.com/leanmeals.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r5 = Restaurant.builder()
                    .name("NutriBox")
                    .location("West End")
                    .rating(4.6)
                    .deliveryTime(28)
                    .image("https://example.com/nutribox.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r6 = Restaurant.builder()
                    .name("Power Kitchen")
                    .location("City Center")
                    .rating(4.1)
                    .deliveryTime(22)
                    .image("https://example.com/powerkitchen.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r7 = Restaurant.builder()
                    .name("Organic Fuel")
                    .location("Old Town")
                    .rating(4.3)
                    .deliveryTime(27)
                    .image("https://example.com/organicfuel.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r8 = Restaurant.builder()
                    .name("Clean Eats")
                    .location("Midtown")
                    .rating(4.5)
                    .deliveryTime(24)
                    .image("https://example.com/cleaneats.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r9 = Restaurant.builder()
                    .name("Veggie Express")
                    .location("East Side")
                    .rating(4.0)
                    .deliveryTime(32)
                    .image("https://example.com/veggieexpress.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Restaurant r10 = Restaurant.builder()
                    .name("Wholesome Bites")
                    .location("Suburbia")
                    .rating(4.7)
                    .deliveryTime(26)
                    .image("https://example.com/wholesomebites.jpg")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            restaurantRepository.saveAll(List.of(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10));

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

            Dish d4 = Dish.builder()
                    .name("Tofu Stir Fry")
                    .price(20.0)
                    .image("https://example.com/tofu.jpg")
                    .description("Tofu with broccoli and bell peppers")
                    .restaurant(r3)
                    .build();

            Dish d5 = Dish.builder()
                    .name("Lean Turkey Wrap")
                    .price(19.0)
                    .image("https://example.com/turkeywrap.jpg")
                    .description("Turkey breast with lettuce and whole wheat wrap")
                    .restaurant(r4)
                    .build();

            Dish d6 = Dish.builder()
                    .name("Protein Smoothie")
                    .price(15.5)
                    .image("https://example.com/smoothie.jpg")
                    .description("Banana, almond butter, whey protein")
                    .restaurant(r5)
                    .build();

            Dish d7 = Dish.builder()
                    .name("Vegan Burger")
                    .price(23.0)
                    .image("https://example.com/veganburger.jpg")
                    .description("Chickpea patty with avocado spread")
                    .restaurant(r6)
                    .build();

            Dish d8 = Dish.builder()
                    .name("Salmon Bowl")
                    .price(26.0)
                    .image("https://example.com/salmon.jpg")
                    .description("Grilled salmon with wild rice and spinach")
                    .restaurant(r7)
                    .build();

            Dish d9 = Dish.builder()
                    .name("Greek Yogurt Parfait")
                    .price(14.0)
                    .image("https://example.com/parfait.jpg")
                    .description("Yogurt with granola and berries")
                    .restaurant(r8)
                    .build();

            Dish d10 = Dish.builder()
                    .name("Stuffed Peppers")
                    .price(21.5)
                    .image("https://example.com/peppers.jpg")
                    .description("Bell peppers stuffed with quinoa and black beans")
                    .restaurant(r9)
                    .build();

            Dish d11 = Dish.builder()
                    .name("Zucchini Noodles")
                    .price(20.0)
                    .image("https://example.com/zoodles.jpg")
                    .description("Zoodles with pesto sauce and cherry tomatoes")
                    .restaurant(r10)
                    .build();

            dishRepository.saveAll(List.of(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11));

            System.out.println("Sample restaurants and dishes inserted!");
        }
    }
}
