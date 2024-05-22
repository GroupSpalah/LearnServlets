package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/json")
public class JsonServlet extends HttpServlet {


    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reader = req.getReader();//json

        Person person = MAPPER.readValue(reader, Person.class);//jackson

        System.out.println(person);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person ben = Person
                .builder()
                .age(50)
                .name("Ben")
                .build();

        String json = MAPPER.writeValueAsString(ben);

        resp.getWriter().println(json);

    }
}

/**

  {
  "name": "John",
   "age": 32
  }


 * */
