package org.example.homeworks.misha.hw_15_05_2024;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Any fool can write code that a computer can understand.\n" +
                "Good programmers write code that humans can\n" +
                "understand.");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Any fool can write code that a computer can understand.\n" +
                "Good programmers write code that humans can\n" +
                "understand.");

    }
}
