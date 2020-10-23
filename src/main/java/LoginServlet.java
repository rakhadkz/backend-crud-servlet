import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (!login.equals("admin") || !password.equals("secret")){
            request.setAttribute("Error", "Incorrect login or password");
            response.sendRedirect("login");
            return;
        }
        session.setAttribute("login", login);
        Date date = new Date(session.getCreationTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        Cookie cookie = new Cookie("session_created_at", simpleDateFormat.format(date));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        response.sendRedirect("catalogs");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
