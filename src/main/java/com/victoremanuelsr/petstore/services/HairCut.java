package com.victoremanuelsr.petstore.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.victoremanuelsr.petstore.model.Service;
import com.victoremanuelsr.petstore.modules.PetStoreModule;

public class HairCut {
    private final Service service;
    private static final Injector injector = Guice.createInjector(new PetStoreModule());
    public enum types {LONG, SHORT};

    public HairCut() {
        this.service = injector.getInstance(Service.class);
    }
    public static HairCut hairCut(){
        return injector.getInstance(HairCut.class);
    }
    public HairCut type(HairCut.types type){
        if(type.equals(types.LONG)){
            service.setNameService("Long haircut");
            service.setPrice(40.00);
        }else if(type.equals(types.SHORT)){
            service.setNameService("Short haircut");
            service.setPrice(20.00);
        }
        return this;
    }
    public Service build(){
        return this.service;
    }
}
