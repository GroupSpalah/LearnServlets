package org.homeworks.anton.hw_15_05.hw_22_05_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsona")
public class CalcJson extends HttpServlet {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reader = req.getReader();
        Calculator calculator = MAPPER.readValue(reader, Calculator.class);
        double result = calculate(calculator.getValueOne(), calculator.getValueTwo(), calculator.getOperation());
        System.out.println(result);
    }

    private double calculate(double valueOne, double valueTwo, String operation) {
        return switch (operation) {
            case "+" -> valueOne + valueTwo;
            case "-" -> valueOne - valueTwo;
            case "*" -> valueOne * valueTwo;
            case "/" -> valueOne / valueTwo;
            default -> 0;
        };
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Calculator calculator = Calculator.builder()
                .valueOne(10)
                .valueTwo(100)
                .operation("*")
                .build();

        String json = MAPPER.writeValueAsString(calculator);
        resp.getWriter().println(json);
    }
}
