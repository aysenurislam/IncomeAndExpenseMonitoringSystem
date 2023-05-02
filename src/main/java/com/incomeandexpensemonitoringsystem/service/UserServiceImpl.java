package com.incomeandexpensemonitoringsystem.service;

import com.incomeandexpensemonitoringsystem.dto.CategoryDto;
import com.incomeandexpensemonitoringsystem.dto.UserDto;
import com.incomeandexpensemonitoringsystem.entity.Category;
import com.incomeandexpensemonitoringsystem.entity.Users;
import com.incomeandexpensemonitoringsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }
    @Override
    public void delete (Long userId) { userRepository.deleteById(userId);}

    @Override
    public UserDto findById (Long id){
        try{
            Users usersFound= userRepository.findById(id).get();
            return modelMapper.map(usersFound, UserDto.class);
        }catch(Exception e){
            throw new NoSuchElementException("Element not found");
        }
    }
    @Override
    public UserDto save (UserDto userDto){
        Users  newUser= modelMapper.map(userDto, Users.class);
        return modelMapper.map(userRepository.save(newUser), UserDto.class);
    }
    @Override
    public UserDto update(Long id, UserDto userDto){
        Users newUser = modelMapper.map(userDto, Users.class);

        Users userFromDB = userRepository.findById(id).get();
        userFromDB.setName(newUser.getName());
        userFromDB.setSurname(newUser.getSurname());
        userFromDB.setEmail(newUser.getEmail());
        userFromDB.setNickname(newUser.getNickname());
        userRepository.save(userFromDB);

        UserDto newUserDto = modelMapper.map(userFromDB , UserDto.class);
        return newUserDto;
    }
}
