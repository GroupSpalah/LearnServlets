package org.homeworks.anton.hw_15_05.hw_05_06_24;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/notebook")
public class NotebookServlet extends HttpServlet {
    private static final ObjectMapper MAPPER = new ObjectMapper();
   private static final NotebookDao NOTEBOOK_DAO = new NotebookDao();;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Notebook notebook = MAPPER.readValue(reader, Notebook.class);

        NOTEBOOK_DAO.ad(notebook);
        resp.getWriter().write(MAPPER.writeValueAsString(notebook));
    }

    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
      Notebook notebook =   NOTEBOOK_DAO.findById(id);
        resp.getWriter().write(MAPPER.writeValueAsString(notebook));
    }
}
