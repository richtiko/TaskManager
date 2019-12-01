package com;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetTasks extends HttpServlet {
    List<String> tasks = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        tasks.add("aaaa");
        tasks.add("bbbb");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        synchronized (tasks) {
            req.setAttribute("tasks", tasks);
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = (String)req.getParameter("taskname");
        synchronized (tasks) {
            tasks.add(task);    
        }
        resp.sendRedirect(req.getContextPath());
    }
}
