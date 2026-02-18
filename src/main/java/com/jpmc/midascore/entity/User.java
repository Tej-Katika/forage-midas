package com.jpmc.midascore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "balance", nullable = false)
    private Float balance;

    // Default constructor (required by JPA)
    public User() {
    }

    public User(Long userId, String username, Float balance) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}