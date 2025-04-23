package com.fitme.backend.dto;

public record CreateDishInput(
        String name,
        Double price,
        String image,
        String description,
        Long restaurantId
) {}
