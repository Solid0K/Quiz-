package com.Krishu.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Result> results;
}
