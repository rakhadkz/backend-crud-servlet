import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("productID"));
        System.out.println(request.getParameter("price"));
        for (Cookie cookie1: request.getCookies()){
            if (cookie1.getName().equals(request.getParameter("productID"))){
                cookie1.setValue(String.valueOf(Integer.parseInt(cookie1.getValue()) + Integer.parseInt(request.getParameter("price"))));
                cookie1.setMaxAge(20);
                response.addCookie(cookie1);
                response.setStatus(200);
                response.reset();
                return;
            }
        }
        Cookie cookie = new Cookie(request.getParameter("productID"), request.getParameter("price"));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        response.sendRedirect("catalogs");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}
