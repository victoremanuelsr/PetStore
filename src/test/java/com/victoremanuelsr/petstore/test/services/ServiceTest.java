package com.victoremanuelsr.petstore.test.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.victoremanuelsr.petstore.exceptions.InvalidPetException;
import com.victoremanuelsr.petstore.model.Pet;
import com.victoremanuelsr.petstore.model.Service;
import com.victoremanuelsr.petstore.modules.PetStoreModule;
import com.victoremanuelsr.petstore.services.Bath;
import com.victoremanuelsr.petstore.services.HairCut;
import com.victoremanuelsr.petstore.services.PetStoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceTest {
    private final Injector injector = Guice.createInjector(new PetStoreModule());
    private final PetStoreService service = injector.getInstance(PetStoreService.class);
    @Test
    public void newPetTest(){
        service.newPet(1, "Bob", "Dog", "Rottweiler", 3.0);
        Assertions.assertEquals("Bob", service.getPet(1).getName());
    }
    @Test
    public void newBathTest(){
        newPetTest();
        Assertions.assertEquals("Bath performed successfully.", service.doBath(1, true, Bath.types.WATER));
        Assertions.assertEquals("Bath performed successfully.", service.doBath(1, false, Bath.types.DRY));
    }
    @Test
    public void newHaircutTest() {
        newPetTest();
        Assertions.assertEquals("Haircut performed successfully.", service.doHairCut(1, HairCut.types.LONG));
        Assertions.assertEquals("Haircut performed successfully.", service.doHairCut(1, HairCut.types.SHORT));
    }
    @Test
    public void searchByAgeTest(){
        newPetTest();
        List<Pet> pets = service.searchByAge(3.0);
        Pet pet = service.getPet(1);
        Assertions.assertTrue(pets.contains(pet));
    }
    @Test
    public void removePetTest(){
        service.newPet(2, "Miu", "Cat", "RagDoll", 5.0);
        Assertions.assertEquals(service.removePet(2), "Successfully removed pet.");
    }
    @Test
    public void top10petsTest(){
        PetStoreService.listServices.clear();
        service.newPet(1, "Bob", "Dog", "Rottweiler", 3.0);
        service.newPet(2, "Miu", "Cat", "RagDoll", 5.0);
        service.newPet(3, "Apollo", "Dog", "Pit bull", 1.5);
        service.doBath(1, true, Bath.types.DRY);
        service.doBath(3, false, Bath.types.WATER);
        service.doHairCut(1, HairCut.types.LONG);
        List<Pet> top10 = service.top10();
        Assertions.assertFalse(top10.isEmpty());
    }
    @Test
    public void historicServiceTest(){
        top10petsTest();
        List<Service> services = service.historic(1);
        Assertions.assertEquals(2, services.size());
    }

    @Test
    public void bathInvalidTest(){
        newPetTest();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.doBath(1, true, Bath.types.valueOf("Invalid"));
        });
    }
    @Test
    public void haircutInvalidTest(){
        newPetTest();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.doHairCut(1, HairCut.types.valueOf("Invalid"));
        });
    }
    @Test
    public void petInvalidTest(){
        Assertions.assertThrows(InvalidPetException.class, () -> {
            PetStoreService.pets.clear();
            service.doHairCut(1, HairCut.types.SHORT);
        });
    }
    @Test
    public void invalidRemovePetTest(){
        Assertions.assertThrows(InvalidPetException.class, () -> {
            PetStoreService.pets.clear();
            service.removePet(2);
        });
    }
    @Test
    public void emptyAgeSearchTest(){
        List<Pet> pets = service.searchByAge(1.0);
        Assertions.assertTrue(pets.isEmpty());
    }
}
