package pao.unibuc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkSession")
public class CheckSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        if(session == null){
            out.write("<html><body>"+
                    "<p><a href=\"index.jsp\">Home</a></p>"+
                    "<h1>Session is not present</h1></body></html>");
        }
        else {
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            System.out.println("Name and email were retrieved from session");
            out.write("<html><body>"+
                    "<p><a href=\"index.jsp\">Home</a></p>"+
                    "<h1>Name in session is " + name + " and email is " + email+ "</h1></body></html>");
        }
    }
}
