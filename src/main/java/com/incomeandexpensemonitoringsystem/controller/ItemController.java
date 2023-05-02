package com.incomeandexpensemonitoringsystem.controller;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.dto.ItemDto;
import com.incomeandexpensemonitoringsystem.service.CategoryService;
import com.incomeandexpensemonitoringsystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itemApi")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/createItem")
    public ResponseEntity createCategory(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.save(itemDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/removeItem/{id}")
    public ResponseEntity<Long> deletecategory(@PathVariable Long id){
        itemService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/items/(id}")
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(itemService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/updateItem/(id}")
    public ResponseEntity updateCategory(@PathVariable("id") Long id, @RequestBody ItemDto itemDto){
        return new ResponseEntity<>(itemService.update(id, itemDto), HttpStatus.OK);
    }
}
