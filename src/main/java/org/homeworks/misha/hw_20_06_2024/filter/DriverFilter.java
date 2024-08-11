package org.homeworks.misha.hw_20_06_2024.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homeworks.misha.hw_20_06_2024.domain.DriverM;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebFilter(urlPatterns = "/driver/m/*")
public class DriverFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        BufferedReader reader = servletRequest.getReader();
        ObjectMapper mapper = new ObjectMapper();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        DriverM driverM = mapper.readValue(reader, DriverM.class);

        if (driverM.getAge() < 18) {
            response.getWriter().print("Incorrect age");
            response.setStatus(403);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
