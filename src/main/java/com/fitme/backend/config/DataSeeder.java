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
                Map.entry("Quinoa Power Bowl", "A nutritious bowl packed with quinoa, fresh seasonal veggies, chickpeas, and lean grilled chicken. Perfectly balanced with a lemon-tahini dressing."),
                Map.entry("Avocado Chicken Wrap", "A soft tortilla wrap filled with creamy avocado slices, grilled chicken breast, crunchy lettuce, and a zesty lime dressing."),
                Map.entry("Kale Caesar Salad", "A healthy twist on the traditional Caesar salad, made with crisp kale, shaved parmesan, whole grain croutons, and a light Greek yogurt Caesar dressing."),
                Map.entry("Tofu Teriyaki Bowl", "Pan-seared tofu glazed in homemade teriyaki sauce, served over brown rice with steamed broccoli, carrots, and edamame."),
                Map.entry("Turkey Spinach Wrap", "Lean turkey breast layered with fresh spinach, cucumbers, tomatoes, and a spread of hummus, all wrapped in a whole wheat tortilla."),
                Map.entry("Chickpea Buddha Bowl", "A hearty, plant-based bowl featuring roasted chickpeas, brown rice, roasted sweet potatoes, avocado, and a tahini lemon drizzle."),
                Map.entry("Greek Yogurt Salad", "Crisp cucumbers, cherry tomatoes, red onion, and olives tossed in a tangy Greek yogurt dressing with crumbled feta cheese."),
                Map.entry("Spicy Lentil Wrap", "A bold and flavorful wrap made with spicy lentil mash, spinach, red cabbage slaw, and chipotle aioli in a multigrain tortilla."),
                Map.entry("Sweet Potato Bowl", "Roasted sweet potatoes served with kale, kidney beans, black rice, and a creamy tahini dressing."),
                Map.entry("Grilled Chicken Caesar", "Juicy grilled chicken breast slices atop romaine lettuce with parmesan cheese, multigrain croutons, and a light Caesar dressing."),
                Map.entry("Smoky Tempeh Bowl", "Smoky-flavored tempeh cubes served with red quinoa, black beans, grilled corn, and avocado slices."),
                Map.entry("Zucchini Noodle Salad", "Spiralized zucchini tossed with cherry tomatoes, fresh basil, mozzarella pearls, and balsamic glaze."),
                Map.entry("Salmon Avocado Bowl", "Seared salmon fillet paired with avocado, wild rice, pickled onions, and miso dressing."),
                Map.entry("Veggie Hummus Wrap", "Grilled zucchini, bell peppers, and red onions with a generous spread of hummus in a spinach wrap."),
                Map.entry("Lentil Quinoa Salad", "Protein-rich lentils and quinoa mixed with cucumbers, tomatoes, parsley, and a lemon vinaigrette."),
                Map.entry("Stuffed Bell Peppers", "Bell peppers filled with ground turkey, black beans, corn, and quinoa, baked and topped with light cheese."),
                Map.entry("Asian Noodle Bowl", "Soba noodles tossed with shredded cabbage, carrots, edamame, sesame seeds, and soy-ginger dressing."),
                Map.entry("Black Bean Wrap", "A filling wrap made with mashed black beans, avocado, lettuce, and a mild chipotle sauce."),
                Map.entry("Coconut Chickpea Curry", "Chickpeas simmered in coconut milk and curry spices, served with basmati rice and cilantro."),
                Map.entry("Grilled Shrimp Salad", "Mixed greens topped with grilled shrimp, mango chunks, avocado, and a citrus vinaigrette."),
                Map.entry("Falafel Pita", "Crispy baked falafel balls served in warm pita with cucumbers, tomatoes, and tahini yogurt sauce."),
                Map.entry("Eggplant Caprese Bowl", "Grilled eggplant, tomatoes, basil, and mozzarella layered over farro with a balsamic reduction."),
                Map.entry("Broccoli Tofu Stir-Fry", "Tofu and broccoli stir-fried with garlic, ginger, and tamari sauce served with jasmine rice."),
                Map.entry("Buffalo Cauliflower Wrap", "Spicy buffalo-style roasted cauliflower, carrots, celery, and vegan ranch dressing in a tortilla."),
                Map.entry("Spinach Feta Wrap", "Spinach, crumbled feta cheese, olives, and sun-dried tomatoes in a whole grain wrap."),
                Map.entry("BBQ Chicken Bowl", "Shredded BBQ chicken served with brown rice, black beans, corn, and coleslaw."),
                Map.entry("Rainbow Veggie Bowl", "Colorful mix of roasted bell peppers, carrots, beets, and spinach over couscous with a herb dressing."),
                Map.entry("Avocado Toast Salad", "Mixed greens topped with sliced avocado toast bites, cherry tomatoes, and poached egg."),
                Map.entry("Miso Soup & Rice Bowl", "A classic miso soup paired with a simple rice bowl topped with seaweed and tofu cubes."),
                Map.entry("Pesto Pasta Salad", "Whole wheat pasta tossed with basil pesto, cherry tomatoes, arugula, and pine nuts."),
                Map.entry("Lemon Herb Chicken Wrap", "Tender grilled chicken seasoned with lemon and herbs, wrapped with arugula and tzatziki."),
                Map.entry("Crispy Tofu Wrap", "Crunchy tofu strips, cabbage, carrots, and peanut sauce wrapped in a rice paper roll."),
                Map.entry("Bulgur Wheat Bowl", "Nutty bulgur wheat, parsley, cucumbers, cherry tomatoes, and lemon dressing."),
                Map.entry("Mushroom Barley Soup", "Savory soup made with barley, mushrooms, onions, and carrots in a light vegetable broth."),
                Map.entry("Peanut Tempeh Wrap", "Tempeh slices glazed with spicy peanut sauce, lettuce, carrots, and cilantro in a tortilla."),
                Map.entry("Mediterranean Chickpea Bowl", "A fusion bowl with chickpeas, olives, tabbouleh, hummus, and grilled eggplant."),
                Map.entry("Roasted Veggie Couscous", "Couscous base topped with roasted zucchini, squash, red onions, and a lemon dressing."),
                Map.entry("Hearty Lentil Soup", "Rich lentil soup with carrots, celery, and a touch of tomato paste, slow-cooked for depth."),
                Map.entry("Southwest Quinoa Salad", "Quinoa, black beans, corn, red pepper, avocado, and spicy lime dressing."),
                Map.entry("Shrimp Avocado Wrap", "Grilled shrimp, avocado, spicy mayo, shredded lettuce, and red onions wrapped in soft tortilla."),
                Map.entry("Grilled Veggie Panini", "Zucchini, bell peppers, eggplant, and provolone cheese pressed in whole grain bread."),
                Map.entry("Cauliflower Rice Bowl", "Low-carb bowl with cauliflower rice, black beans, avocado, salsa, and grilled tofu."),
                Map.entry("Teriyaki Jackfruit Wrap", "Pulled jackfruit in teriyaki sauce with slaw and spicy mayo in a tortilla."),
                Map.entry("Edamame Noodle Salad", "Chilled rice noodles, edamame, carrots, cilantro, and sesame-ginger dressing."),
                Map.entry("Spaghetti Squash Bowl", "Roasted spaghetti squash topped with tomato-basil sauce and vegan meatballs."),
                Map.entry("Herbed Tuna Wrap", "Tuna salad made with Greek yogurt, herbs, celery, and lettuce in a spinach wrap."),
                Map.entry("Wild Rice Beet Bowl", "Wild rice and roasted beets with arugula, goat cheese, and citrus vinaigrette."),
                Map.entry("Pumpkin Curry Bowl", "Creamy pumpkin curry with chickpeas, coconut milk, and jasmine rice."),
                Map.entry("Asian Slaw Wrap", "Crunchy slaw with sesame dressing, grilled tofu, and cilantro in a rice wrap."),
                Map.entry("Ginger Chicken Bowl", "Ginger-marinated grilled chicken over soba noodles and steamed snow peas.")
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
                for (int j = 0; j < 3; j++) {
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