package com.bootcamp_2024_2.emazon.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void categoryBuilderTest() {
        category = new Category(1L, "Clothing", "Fashionable items");

        assertEquals(1L, category.getId());
        assertEquals("Clothing", category.getName());
        assertEquals("Fashionable items", category.getDescription());
    }

    @Test
    void categorySettersTest() {
        category.setId(1L);
        category.setName("Electronics");
        category.setDescription("Gadgets and devices");

        assertEquals(1L, category.getId());
        assertEquals("Electronics", category.getName());
        assertEquals("Gadgets and devices", category.getDescription());
    }
}
