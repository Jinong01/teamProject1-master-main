package com.koreait.coffee.model.dto;

import java.time.LocalDateTime;

public class ShoppingCart {
    private Integer id;
    private Integer userId;
    private Integer dishId;
    private double amount;
    private Integer number;
    private Type type;
    private LocalDateTime createTime;
    private Temperature temperature;
    private Shot shot;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer id, Integer userId, Integer dishId, double amount, Integer number, Type type, LocalDateTime createTime, Temperature temperature, Shot shot) {
        this.id = id;
        this.userId = userId;
        this.dishId = dishId;
        this.amount = amount;
        this.number = number;
        this.type = type;
        this.createTime = createTime;
        this.temperature = temperature;
        this.shot = shot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", dishId=" + dishId +
                ", amount=" + amount +
                ", number=" + number +
                ", type=" + type +
                ", createTime=" + createTime +
                ", temperature=" + temperature +
                ", shot=" + shot +
                '}';
    }
}
