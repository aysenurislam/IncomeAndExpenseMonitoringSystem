package com.incomeandexpensemonitoringsystem.controller;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoryApi")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public ResponseEntity createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/removeCategory/{id}")
    public ResponseEntity<Long> deletecategory(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/categories/(id}")
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/updateCategory/(id}")
    public ResponseEntity updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.update(id, categoryDto), HttpStatus.OK);
    }
}
