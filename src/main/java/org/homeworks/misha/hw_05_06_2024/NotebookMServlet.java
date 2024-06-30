package org.homeworks.misha.hw_05_06_2024;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homeworks.misha.hw_05_06_2024.dao.NotebookDAO;
import org.homeworks.misha.hw_05_06_2024.domain.NotebookM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/notebookM")
public class NotebookMServlet extends HttpServlet {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static final NotebookDAO NOTEBOOK_DAO = new NotebookDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        NotebookM notebook = MAPPER.readValue(reader, NotebookM.class);
        NOTEBOOK_DAO.add(notebook);
        resp.getWriter().write(MAPPER.writeValueAsString(notebook));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        NotebookM notebook = NOTEBOOK_DAO.findById(id);
        resp.getWriter().write(MAPPER.writeValueAsString(notebook));
    }
}
