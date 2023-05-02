package com.incomeandexpensemonitoringsystem.controller;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.dto.ItemDto;
import com.incomeandexpensemonitoringsystem.dto.UserDto;
import com.incomeandexpensemonitoringsystem.service.CategoryService;
import com.incomeandexpensemonitoringsystem.service.ItemService;
import com.incomeandexpensemonitoringsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userApi")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity createCategory(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/removeUser/{id}")
    public ResponseEntity<Long> deletecategory(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/users/(id}")
    public ResponseEntity findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/updateUser/(id}")
    public ResponseEntity updateCategory(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.update(id, userDto), HttpStatus.OK);
    }
}
