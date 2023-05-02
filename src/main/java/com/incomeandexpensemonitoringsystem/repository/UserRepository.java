package com.incomeandexpensemonitoringsystem.repository;

import com.incomeandexpensemonitoringsystem.entity.Item;
import com.incomeandexpensemonitoringsystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
}
