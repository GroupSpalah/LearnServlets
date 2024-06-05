package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/json")
public class JsonServlet extends HttpServlet {


    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        BufferedReader reader = req.getReader();//json

//        {
//            "id": 0,
//                "name": "John",
//                "age": 32
//        }
//        new PersonService().save(person)

        Person person = MAPPER.readValue(reader, Person.class);//jackson, id = 0

        System.out.println(person);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();//json

        //        {
//            "id": !=0,
//                "name": "John",
//                "age": 32
//        }

        //        new PersonService().update(person)

        Person person = MAPPER.readValue(reader, Person.class);//jackson

        System.out.println(person);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person ben = Person
                .builder()
                .age(50)
                .name("Ben")
                .build();
        String sId = req.getParameter("id");

        int id = Integer.parseInt(sId);

        ben.setId(id);

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
