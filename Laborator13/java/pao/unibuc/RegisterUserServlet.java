package pao.unibuc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet init method was called");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy init method was called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost init method was called");
        createUser(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet init method was called");
        createUser(req, resp);
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        UserDB.getInstance().addUser(name, email,
                UserDB.getInstance().getAllUsers().stream()
                        .map(user-> user.getName())
                        .collect(Collectors.toList()));

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("name", name);
        httpSession.setAttribute("email", email);

        resp.getWriter().write("<html><body>+" +
                "<p><a href=\"index.jsp\">Home</a></p>" +
                "<h2>Name and email were stored</h2></body></html>");
    }
}
