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
@Table(name="role")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Role implements Serializable {

    @Id
    @Column(name=" id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="role",
    cascade = CascadeType.ALL, // cascade ekleyince post hatas gitti
    orphanRemoval = true)
    private List<Users> users = new ArrayList<>();
}
