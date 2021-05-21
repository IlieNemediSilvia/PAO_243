package pao.unibuc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        PrintWriter writer = resp.getWriter();
        if(session == null){
            writer.write("<html><body>"+
                    "<p><a href=\"index.jsp\">Home</a></p>"+
                    "<h1>Session not present</h1></body></html");
        }
        else {
            session.invalidate();
            writer.write("<html><body>"+
                    "<p><a href=\"index.jsp\">Home</a></p>"+
                    "<h1>Session was invalidated</h1></body></html");
        }
    }
}
