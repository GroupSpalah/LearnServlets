package org.homeworks.misha.hw_25_05_2024;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsonM")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pNum1 = req.getParameter("num1");
        String pNum2 = req.getParameter("num2");
        String sign = req.getParameter("sign");

        int num1 = Integer.parseInt(pNum1);
        int num2 = Integer.parseInt(pNum2);
        int result;

        switch (sign) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                    break;
                } else {
                    resp.getWriter().println("Division by zero is not allowed!");
                }

            default:
                throw new IllegalStateException("Unexpected value: " + sign);
        }

        resp.getWriter().println(num1 + sign + num2 + "=" + result);

    }
}
