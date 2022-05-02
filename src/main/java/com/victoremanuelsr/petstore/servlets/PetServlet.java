package com.victoremanuelsr.petstore.servlets;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.victoremanuelsr.petstore.modules.PetStoreModule;
import com.victoremanuelsr.petstore.services.PetStoreService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
@WebServlet(urlPatterns="/pet")
public class PetServlet extends HttpServlet {
    Injector injector = Guice.createInjector(new PetStoreModule());
    PetStoreService service = injector.getInstance(PetStoreService.class);
    private Integer id;
    private Double age;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String breed = req.getParameter("breed");
        id = Integer.parseInt(req.getParameter("id"));
        age = Double.parseDouble(req.getParameter("age"));
        service.newPet(id, name, type, breed, age);
        resp.getWriter().write("Pet " + name +"  has been adding successfully.");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        id = Integer.parseInt(req.getParameter("id"));
        resp.getWriter().write(service.removePet(id));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        age = Double.parseDouble(req.getParameter("age"));
        resp.getWriter().write(service.searchByAge(age).toString());
    }
}
