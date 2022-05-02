package com.victoremanuelsr.petstore.modules;

import com.google.inject.AbstractModule;
import com.victoremanuelsr.petstore.model.Pet;
import com.victoremanuelsr.petstore.model.Race;
import com.victoremanuelsr.petstore.model.Service;
import com.victoremanuelsr.petstore.services.Bath;
import com.victoremanuelsr.petstore.services.HairCut;
import com.victoremanuelsr.petstore.services.PetStoreService;

public class PetStoreModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PetStoreService.class);
        bind(Pet.class);
        bind(Race.class);
        bind(Bath.class);
        bind(Service.class);
        bind(HairCut.class);
    }
}
