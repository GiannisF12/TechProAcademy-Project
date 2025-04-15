package com.giannis.proxysystem;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/proxy-system")
public class ProxySystem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("System reached");

        // Optional: Forward to swagger UI
        resp.sendRedirect("http://localhost:8081/swagger-ui/index.html");
    }
}