package org.homeworks.anton.hw_15_05.hw_22_05;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String valueOne = req.getParameter("one");
        String valueTwo = req.getParameter("two");
        String operation = req.getParameter("operation");
        double val1 = Double.parseDouble(valueOne);
        double val2 = Double.parseDouble(valueTwo);

        double result = switch (operation) {
            case "+" -> val1 + val2;
            case "-" -> val1 - val2;
            case "*" -> val1 * val2;
            case "/" -> val1 / val2;
            default -> 0;

        };
        resp.getWriter().println("Result is: " + result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first = req.getParameter("one");
        String second = req.getParameter("two");
        String operation = req.getParameter("operation");
        float num1 = Short.parseShort(first);
        float num2 = Short.parseShort(second);

        float result = switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;

        };
        resp.getWriter().println("Result is: " + result);
    }
}

