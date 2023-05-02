package com.incomeandexpensemonitoringsystem.service;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.entity.Category;

public interface CategoryService {
    Iterable<Category> findAll();
    CategoryDto findById(Long id);
    CategoryDto save(CategoryDto categoryDto);
    void delete (Long id);
    CategoryDto update(Long id, CategoryDto categoryDto);
}
