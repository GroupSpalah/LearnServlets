package org.homeworks.anton.hw_16_06_24.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homeworks.anton.hw_16_06_24.domain.Truck;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebFilter(urlPatterns = "/truck/*")
public class TruckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        BufferedReader reader = request.getReader();

        ObjectMapper mapper = new ObjectMapper();

        Truck truck = mapper.readValue(reader, Truck.class);

        if (truck.getDate() < 2022) {
            response.getWriter().println("Incorrect date");
            response.setStatus(403);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}



