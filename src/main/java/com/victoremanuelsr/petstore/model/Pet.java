package com.victoremanuelsr.petstore.model;

public class Pet implements Comparable<Pet> {
    private Integer id;
    private String name;
    private Race race;
    private Double age;
    private Double spending = 0.00;

    public Pet() {
    }

    public Pet(Integer id, String name, Race race, Double age) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public Double getAge() {
        return age;
    }

    public Double getSpending() {
        return spending;
    }

    public void setSpending(Double spending) {
        this.spending = spending;
    }


    @Override
    public String toString() {
        return "ID: " + getId() + "; Name: " + getName() + "; " + getRace() + "; Age: " + getAge() + "; Spending: $" + getSpending();
    }
    @Override
    public int compareTo(Pet pet) {
        return pet.getSpending().compareTo(this.getSpending());
    }
}
