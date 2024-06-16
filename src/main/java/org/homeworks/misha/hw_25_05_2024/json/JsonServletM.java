package org.homeworks.misha.hw_25_05_2024.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homeworks.misha.hw_25_05_2024.Calculate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsonM1")

public class JsonServletM extends HttpServlet {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        CalculateJson calculateJson = MAPPER.readValue(reader, CalculateJson.class);
        System.out.println(calculateJson);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculateJson calculateJson = CalculateJson
                .builder()
                .num2(10)
                .num1(20)
                .sign("/")
                .build();
        String json = MAPPER.writeValueAsString(calculateJson);
        resp.getWriter().println(json);
    }

}
