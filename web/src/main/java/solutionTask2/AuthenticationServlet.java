package solutionTask2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String body = Files.readString(Paths
                .get("C:\\Users\\astah\\Task2\\web\\src\\main\\resources\\html\\authentication.html"));
        var writer = resp.getWriter();
        writer.println(body);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Object object = null;
        try {
            object = UserServlet.userService.logIn(login, password).getClass();
            resp.sendRedirect("/user");
        } catch (UserExistsException e) {
            resp.setContentType("text/html");
            var writer = resp.getWriter();
            writer.println(e.getMessage());
        }




    }
}
