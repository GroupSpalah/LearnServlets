package org.example.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Man;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebFilter(urlPatterns = "/info/*")
public class ManFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        BufferedReader reader = request.getReader();

        ObjectMapper mapper = new ObjectMapper();

        Man man = mapper.readValue(reader, Man.class);

        if (man.age() < 25) {
            response.getWriter().println("Incorrect age");
            response.setStatus(403);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}

/**
*
 * info/*
 *
 * info/man/*
 *
 * truck/work
 * driver/work
 *
 * truck/*
 * driver/*
* */
