package org.homeworks.misha.hw_20_06_2024.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homeworks.misha.hw_20_06_2024.domain.DriverM;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.IOException;

//@WebFilter(urlPatterns = "/driver/*")
public class DriverFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        BufferedReader reader = request.getReader();
        ObjectMapper mapper = new ObjectMapper();

        DriverM driverM = mapper.readValue(reader, DriverM.class);

//        if ()

    }
}
