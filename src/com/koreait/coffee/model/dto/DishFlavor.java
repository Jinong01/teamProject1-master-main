package com.koreait.coffee.model.dto;

public class DishFlavor {
    private int id;
    private Integer dishId;
    private String name;
    private Temperature temperature;
    private Shot shot;

    public DishFlavor(int id, Integer dishId, String name, Temperature temperature, Shot shot) {
        this.id = id;
        this.dishId = dishId;
        this.name = name;
        this.temperature = temperature;
        this.shot = shot;
    }

    public DishFlavor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "DishFlavor{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", name='" + name + '\'' +
                ", temperature=" + temperature +
                ", shot=" + shot +
                '}';
    }
}
