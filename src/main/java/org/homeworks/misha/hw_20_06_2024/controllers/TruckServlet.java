package org.homeworks.misha.hw_20_06_2024.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.homeworks.misha.hw_20_06_2024.domain.TruckM;
import org.homeworks.misha.hw_20_06_2024.service.TruckService;
import org.homeworks.misha.hw_20_06_2024.service.impl.TruckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/truck/m")
public class TruckServlet extends HttpServlet {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    TruckService service = new TruckServiceImpl();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        TruckM truck = MAPPER.readValue(reader, TruckM.class);
        service.add(truck);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        TruckM truck = service.findById(id);
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

