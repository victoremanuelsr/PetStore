package com.victoremanuelsr.petstore.model;

public class Race {
    private String type;
    private String breed;

    public Race() {
    }

    public Race(String type, String breed) {
        this.type = type;
        this.breed = breed;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "; Type: "+ getType() + "; Breed: " + getBreed();
    }
}
