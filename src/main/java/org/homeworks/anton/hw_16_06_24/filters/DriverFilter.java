package org.homeworks.anton.hw_16_06_24.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Man;
import org.homeworks.anton.hw_16_06_24.domain.Driver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebFilter(urlPatterns = "/driver/*")
public class DriverFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        BufferedReader reader = request.getReader();

        ObjectMapper mapper = new ObjectMapper();

       Driver driver = mapper.readValue(reader, Driver.class);

        if (driver.getAge() > 18) {
            response.getWriter().println("Incorrect age");
            response.setStatus(403);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}

