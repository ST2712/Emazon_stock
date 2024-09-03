package com.bootcamp_2024_2.emazon.domain.usecase;

import com.bootcamp_2024_2.emazon.domain.api.ICategoryServicePort;
import com.bootcamp_2024_2.emazon.domain.model.Category;
import com.bootcamp_2024_2.emazon.domain.model.CustomPage;
import com.bootcamp_2024_2.emazon.domain.model.CustomPageable;
import com.bootcamp_2024_2.emazon.domain.spi.ICategoryPersistencePort;
import com.bootcamp_2024_2.emazon.infrastructure.exception.CategoryNotFoundException;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category findById(Long id) {
        return categoryPersistencePort.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public CustomPage<Category> findAll(CustomPageable page) {
        return categoryPersistencePort.findAll(page);
    }

    @Override
    public Category save(Category category) {
        return categoryPersistencePort.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        return categoryPersistencePort.findById(id)
                .map(savedCategory -> {
                    savedCategory.setName(category.getName());
                    savedCategory.setDescription(category.getDescription());
                    return categoryPersistencePort.save(savedCategory);
                })
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(categoryPersistencePort.findById(id).isEmpty()){
            throw new CategoryNotFoundException();
        }
        categoryPersistencePort.deleteById(id);
    }
}
