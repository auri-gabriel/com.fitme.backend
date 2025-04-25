package com.fitme.backend.dto;

import lombok.Data;

@Data
public class CreateDishCategoryInput {
    private String name;
    private Long restaurantId;
}