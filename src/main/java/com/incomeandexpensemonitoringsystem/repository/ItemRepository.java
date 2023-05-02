package com.incomeandexpensemonitoringsystem.repository;

import com.incomeandexpensemonitoringsystem.entity.Category;
import com.incomeandexpensemonitoringsystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
