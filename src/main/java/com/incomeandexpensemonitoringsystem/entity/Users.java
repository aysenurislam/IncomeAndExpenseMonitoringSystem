package com.incomeandexpensemonitoringsystem.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.*;
@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="name")
    @Size(max=20)
    @NotBlank
    private Long name;

    @Column(name="surname")
    @Size(max=20)
    @NotBlank
    private String surname;

    @Column(name="nickname", unique=true)
    @Size(max=20)
    @NotBlank
    private String nickname;

    @Column(name="email", unique=true)
    @Size(max=50)
    @NotBlank
    @Email
    private String email;

    @Column(name="password", nullable=false)
    @Size(max=20)
    @NotBlank
    private String password;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="role_id")
    private Role role;
}


