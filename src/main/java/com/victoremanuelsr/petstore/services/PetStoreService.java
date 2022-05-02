package com.victoremanuelsr.petstore.services;

import com.google.inject.Inject;
import com.victoremanuelsr.petstore.exceptions.InvalidPetException;
import com.victoremanuelsr.petstore.exceptions.InvalidServiceException;
import com.victoremanuelsr.petstore.model.Pet;
import com.victoremanuelsr.petstore.model.Race;
import com.victoremanuelsr.petstore.model.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PetStoreService {
    public PetStoreService() {
    }

    public static List<Pet> pets = new ArrayList<>();
    public static List<Service> listServices = new ArrayList<>();
    @Inject
    private Pet pet;
    public void newPet(Integer id, String name, String type, String breed, Double age){
        if(name.isEmpty() || id == null || type.isEmpty() || breed.isEmpty() || age == null){
            throw new InvalidPetException();
        }
        pet = new Pet(id, name, new Race(type, breed), age);
        pets.add(pet);
    }
    public String removePet(Integer id){
        pets.remove(getPet(id));
        return "Successfully removed pet.";
    }
    public Pet getPet(Integer id){
        Pet getPet = null;
        for (Pet pet : pets){
            if(Objects.equals(pet.getId(), id)){
                getPet = pet;
            }
        }
        if(getPet == null){
            throw new InvalidPetException("pet not found.");
        }
        return getPet;
    }
    public List<Pet> searchByAge(Double age){
        List<Pet> result = new ArrayList<>();
        for(Pet pet : pets){
            if(Objects.equals(pet.getAge(), age)){
                result.add(pet);
            }
        }
        return result;
    }
    public String doBath(Integer id, Boolean perfume, Bath.types with){
        pet = getPet(id);
        if(with.equals(Bath.types.DRY) || with.equals(Bath.types.WATER)){
            Service newBath = Bath.bath().perfume(perfume).with(with).build();
            pet.setSpending(pet.getSpending() + newBath.getPrice());
            newBath.setPetId(pet.getId());
            listServices.add(newBath);
            return "Bath performed successfully.";
        }else {
            throw new InvalidServiceException("We do not perform this service.");
        }
    }
    public String doHairCut(Integer id, HairCut.types type){
        pet = getPet(id);
        if(type.equals(HairCut.types.LONG) || type.equals(HairCut.types.SHORT)){
            Service newDoHairCut = HairCut.hairCut().type(type).build();
            pet.setSpending(pet.getSpending() + newDoHairCut.getPrice());
            newDoHairCut.setPetId(pet.getId());
            listServices.add(newDoHairCut);
            return "Haircut performed successfully.";
        }else {
            throw new InvalidServiceException("We do not perform this service.");
        }
    }
    public List<Service> historic(Integer id){
        List<Service> result = new ArrayList<>();
        for(Service service : listServices){
            if(Objects.equals(service.getPetId(), id)){
                result.add(service);
            }
        }
        return result;
    }
    public List<Pet> top10(){
        Collections.sort(pets);
        return pets.stream().limit(10).collect(Collectors.toList());
    }
}
