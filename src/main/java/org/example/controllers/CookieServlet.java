package org.example.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie foto = new Cookie("Foto", "Size");

        foto.setMaxAge(24 * 3600);

        resp.addCookie(foto);

        Cookie auto = new Cookie("Auto", "Bmw");

        resp.addCookie(auto);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();

        Cookie foto1 = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("Foto"))
                .findFirst()
                .get();

        foto1.setMaxAge(0);

        String foto = foto1
                .getValue();

        System.out.println(foto);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
