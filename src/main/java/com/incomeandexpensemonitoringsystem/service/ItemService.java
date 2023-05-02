package com.incomeandexpensemonitoringsystem.service;

import com.incomeandexpensemonitoringsystem.dto.ItemDto;
import com.incomeandexpensemonitoringsystem.entity.Item;

public interface ItemService{
    Iterable<Item> findAll();
    ItemDto findById(Long id);
    ItemDto save (ItemDto itemDto);
    void delete(Long id);
    ItemDto update (Long id, ItemDto itemDto);
}
