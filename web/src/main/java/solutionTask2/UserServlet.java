package solutionTask2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {var user = userService.getUser(1L);
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.write("<html lang=\"ru\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\" />\n" +
                "  <title></title>\n" +
                "  <link rel=\"stylesheet\" href=\"style.css\" />\n" +
                "</head>\n" +
                "<body>\n" +
                " <h1> Пользователь </h1>   \n" +
                "<h2>" + user.get().getName() + "</h2> \n" +
                "</body>\n" +
                "</html>");
        writer.close();
    }
}
