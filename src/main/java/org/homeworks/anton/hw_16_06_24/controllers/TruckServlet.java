package org.homeworks.anton.hw_16_06_24.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.homeworks.anton.hw_16_06_24.domain.Driver;
import org.homeworks.anton.hw_16_06_24.domain.Truck;
import org.homeworks.anton.hw_16_06_24.service.TruckService;
import org.homeworks.anton.hw_16_06_24.service.serviceImpl.TruckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/truck/work")
public class TruckServlet extends HttpServlet {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    TruckService service = new TruckServiceImpl();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Truck truck = MAPPER.readValue(reader, Truck.class);
        service.add(truck);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        Truck truck = service.find(id);
        resp.getWriter().write(MAPPER.writeValueAsString(truck));
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        service.deleteById(id);
    }
}

