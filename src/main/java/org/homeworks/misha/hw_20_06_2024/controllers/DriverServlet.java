package org.homeworks.misha.hw_20_06_2024.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.homeworks.misha.hw_20_06_2024.domain.DriverM;
import org.homeworks.misha.hw_20_06_2024.service.CrudService;
import org.homeworks.misha.hw_20_06_2024.service.impl.DriverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(urlPatterns = "/driver/m")
public class DriverServlet extends HttpServlet {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    CrudService<DriverM> driverService = new DriverServiceImpl();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        DriverM driver = MAPPER.readValue(reader, DriverM.class);
        driverService.add(driver);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        DriverM driver = driverService.findById(id);
        resp.getWriter().write(MAPPER.writeValueAsString(driver));
    }

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        driverService.deleteById(id);
    }
}
