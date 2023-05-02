package com.incomeandexpensemonitoringsystem.service;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.entity.Category;
import com.incomeandexpensemonitoringsystem.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto findById (Long id){
        try{
            Category categoryFound= categoryRepository.findById(id).get();
            return modelMapper.map(categoryFound, CategoryDto.class);
        }catch(Exception e){
            throw new NoSuchElementException("Element not found");
        }
    }
    @Override
    public CategoryDto save (CategoryDto categoryDto){
        Category newCategory= modelMapper.map(categoryDto, Category.class);
        return modelMapper.map(categoryRepository.save(newCategory), CategoryDto.class);
    }

    @Override
    public void delete (Long categoryId) { categoryRepository.deleteById(categoryId);}

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto){
        Category newCategory = modelMapper.map(categoryDto, Category.class);

        Category categoryFromDB = categoryRepository.findById(id).get();
        categoryFromDB.setStatus(newCategory.getStatus());
        categoryRepository.save(categoryFromDB);

        CategoryDto newCategoryDto = modelMapper.map(categoryFromDB , CategoryDto.class);
        return newCategoryDto;
    }
}
