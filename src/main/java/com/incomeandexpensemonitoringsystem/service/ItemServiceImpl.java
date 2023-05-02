package com.incomeandexpensemonitoringsystem.service;

import com.incomeandexpensemonitoringsystem.dto.ItemDto;
import com.incomeandexpensemonitoringsystem.dto.UserDto;
import com.incomeandexpensemonitoringsystem.entity.Item;
import com.incomeandexpensemonitoringsystem.entity.Users;
import com.incomeandexpensemonitoringsystem.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }
    @Override
    public void delete (Long userId) { itemRepository.deleteById(userId);}
    @Override
    public ItemDto findById(Long id) {
        try {
            Item itemFound = itemRepository.findById(id).get();
            return modelMapper.map(itemFound, ItemDto.class);
        } catch (Exception e) {
            throw new NoSuchElementException("Element not found");
        }//bu hata bunada mi controllerda ma verilmeli??
    }

    @Override
    public ItemDto save(ItemDto itemDto){
    Item newItem = modelMapper.map(itemDto, Item.class);
    return modelMapper.map(itemRepository.save(newItem),ItemDto.class);
    }
    @Override
    public ItemDto update(Long id, ItemDto itemDto){
        Item newItem = modelMapper.map(itemDto, Item.class);

        Item itemFromDB = itemRepository.findById(id).get();
        itemFromDB.setName(newItem.getName());


        ItemDto newItemDto = modelMapper.map(itemFromDB , ItemDto.class);
        return newItemDto;
    }
}


