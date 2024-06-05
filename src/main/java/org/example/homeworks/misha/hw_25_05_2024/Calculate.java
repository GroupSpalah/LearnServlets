package org.example.homeworks.misha.hw_25_05_2024;

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
        String plus= req.getParameter("plus");
        String minus = req.getParameter("minus");
        String multiply = req.getParameter("multiply");
        String divide = req.getParameter("divide");


        int num1 = Integer.parseInt(pNum1);
        int num2 = Integer.parseInt(pNum2);
        int resultPlus = num1 + num2;
        int resultMinus = num1 - num2;
        int resultMultiply = num1 * num2;
        int resultDivide = num1 / num2;

//        resp.getWriter().println(num1 + plus + num2 + "=" + resultPlus);
//        resp.getWriter().println(num1 + minus + num2 + "=" + resultMinus);
//        resp.getWriter().println(num1 + multiply + num2 + "=" + resultMultiply);
        resp.getWriter().println(num1 + divide + num2 + "=" + resultDivide);


    }
}
