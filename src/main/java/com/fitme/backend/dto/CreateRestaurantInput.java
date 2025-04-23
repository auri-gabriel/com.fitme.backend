package com.fitme.backend.dto;

import java.time.LocalDateTime;

public record CreateRestaurantInput(
        String name,
        Double rating,
        String location,
        Integer deliveryTime,
        String image
) {
}
