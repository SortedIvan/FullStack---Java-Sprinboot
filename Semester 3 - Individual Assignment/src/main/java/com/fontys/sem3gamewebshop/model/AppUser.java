package com.fontys.sem3gamewebshop.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name ="password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST}) @JsonIgnore
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(targetEntity = Game.class, cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST}) @JsonIgnore
    private Collection<Long> gameIDs = new ArrayList<>();

    public void SetPassword(String newPassword, String oldPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
        }
    }
        @Override
    public String toString() {
        return "User{" +
                "userName=" + this.username +
                ", name='" + this.email + '\'' +
                '}';
    }



}