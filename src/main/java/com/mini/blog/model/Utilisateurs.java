package com.mini.blog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="user_role", nullable=false)
    private EnumUserRole role;

    @Column(name="user_name", nullable = false, length = 50)
    private String name;

    @Column(name="password", nullable = false, length = 250)
    private String password;

}
