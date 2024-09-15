package com.scm.scm.entity;


import java.util.ArrayList;
import java.util.List;

import com.scm.scm.constant.Provider;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String phoneNumber;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profilePic;

    private Boolean enabled = false;
    private Boolean emailVerified = false;
    private Boolean phoneVerified = false;

    private Provider provider = Provider.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();


}
