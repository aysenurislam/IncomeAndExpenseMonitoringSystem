package com.incomeandexpensemonitoringsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Category extends Auditable<String> implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType. IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column (name = "name", unique = true)
    private String name;

    @Column (name = "status", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

}
