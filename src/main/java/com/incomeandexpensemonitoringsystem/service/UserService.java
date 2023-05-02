package com.incomeandexpensemonitoringsystem.service;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.dto.UserDto;
import com.incomeandexpensemonitoringsystem.entity.Category;
import com.incomeandexpensemonitoringsystem.entity.Users;

public interface UserService {
    Iterable<Users> findAll();
    UserDto findById(Long id);
    UserDto save(UserDto userDto);
    void delete (Long id);
    UserDto update(Long id, UserDto userDto);
}
