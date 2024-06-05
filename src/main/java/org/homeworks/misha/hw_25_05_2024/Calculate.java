package org.homeworks.misha.hw_25_05_2024;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pNum1 = req.getParameter("num1");
        String pNum2 = req.getParameter("num2");
        String sign = req.getParameter("sign");

        switch (sign) {

        }

//        resp.getWriter().println(num1 + divide + num2 + "=" + resultDivide);

    }
}
