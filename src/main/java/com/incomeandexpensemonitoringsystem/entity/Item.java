package com.incomeandexpensemonitoringsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column (name="name")
    private String name;

    @Column (name="amount", nullable = false)
    private Double amount;

    @ManyToOne (fetch = FetchType. LAZY)
    @JoinColumn(name = "category id")
    private Category category;
}
