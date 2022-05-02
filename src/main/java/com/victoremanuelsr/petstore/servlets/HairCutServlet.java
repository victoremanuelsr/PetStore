package com.victoremanuelsr.petstore.servlets;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.victoremanuelsr.petstore.modules.PetStoreModule;
import com.victoremanuelsr.petstore.services.HairCut;
import com.victoremanuelsr.petstore.services.PetStoreService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Singleton
@WebServlet(urlPatterns = "/haircut")
public class HairCutServlet extends HttpServlet {
    Injector injector = Guice.createInjector(new PetStoreModule());
    PetStoreService service = injector.getInstance(PetStoreService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        HairCut.types type = HairCut.types.valueOf(req.getParameter("type").toUpperCase(Locale.ROOT));
        resp.getWriter().write(service.doHairCut(id, type));
    }
}
