package com.example.cv_back.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "picture")
    private byte[] picture;

    @Size(max = 5000)
    @NotNull
    @Column(name = "description", nullable = false, length = 5000)
    private String description;

    @Size(max = 100)
    @Column(name = "github", length = 100)
    private String github;

    @Size(max = 100)
    @Column(name = "linkedin", length = 100)
    private String linkedin;

    @Size(max = 100)
    @Column(name = "telephone", length = 100)
    private String telephone;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Size(max = 50)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;


}