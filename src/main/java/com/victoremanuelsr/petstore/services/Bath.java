package com.victoremanuelsr.petstore.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.victoremanuelsr.petstore.model.Service;
import com.victoremanuelsr.petstore.modules.PetStoreModule;

public class Bath {
    private final Service service;
    private static final Injector injector = Guice.createInjector(new PetStoreModule());
    public enum types{DRY, WATER};

    public Bath(){
        this.service = injector.getInstance(Service.class);
    }
    public static Bath bath(){
        return injector.getInstance(Bath.class);
    }

    public Bath perfume(Boolean withPerfume){
        if(withPerfume){
            service.setNameService("with perfume");
            service.setPrice(15.00);
        }else {
            service.setNameService("without perfume");
        }
        return this;
    }
    public Bath with(Bath.types type){
        if(type.equals(types.DRY)){
            service.setNameService( "Dry bath " + service.getNameService());
            Double price = 45.00;
            service.setPrice(price += service.getPrice());
        }else if(type.equals(types.WATER)){
            Double price = 35.00;
            service.setPrice(price += service.getPrice());
            service.setNameService("Water bath " + service.getNameService());
        }
        return this;
    }
    public Service build(){
        return this.service;
    }
}
