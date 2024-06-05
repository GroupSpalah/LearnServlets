package org.example.anton.hw_15_05_24;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PhraseServlet extends HttpServlet {

    @Override
   protected  void  doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer =resp.getWriter();
        writer.print("Any fool can write code that a computer can understand. " +
                "Good programmers write code that humans can"
                +
                "understand.");
}}
