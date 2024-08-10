package org.homeworks.misha.hw_20_06_2024.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homeworks.misha.hw_20_06_2024.domain.TruckM;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class TruckFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        BufferedReader reader = servletRequest.getReader();
        ObjectMapper mapper = new ObjectMapper();

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        TruckM truckM = mapper.readValue(reader, TruckM.class);

        if (truckM.getDate() < 2010) {
            response.getWriter().print("Incorrect date");
            response.setStatus(403);
        } else {
            filterChain.doFilter(request, response);
        }


    }
}
