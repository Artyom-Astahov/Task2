package solutionTask2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    public final static UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("userName", userService.user.getName());
        req.setAttribute("userAge", userService.user.getAge());
        req.setAttribute("userEmail", userService.user.getEmail());
        req.setAttribute("userLogin", userService.user.getLogin());
        req.setAttribute("userPassword", userService.user.getPassword());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/menu.jsp");
        requestDispatcher.forward(req, resp);


    }
}
