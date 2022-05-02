package com.victoremanuelsr.petstore.model;

public class Service {
    private Integer petId;
    private String nameService;
    private Double price = 0.0;

    public Service() {
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PetID: " + getPetId() + "; Service: " + getNameService() + "; Price: $" + getPrice();
    }
}
