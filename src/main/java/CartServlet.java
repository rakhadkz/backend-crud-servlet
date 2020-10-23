import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database database = new Database();
        String pID = request.getParameter("productID");
        if (Database.cart1.containsKey(pID)){
            Database.cart1.put(pID, Database.cart1.get(pID) + Integer.parseInt(request.getParameter("price")));
        }else{
            Database.cart1.put(pID, Integer.parseInt(request.getParameter("price")));
        }
        response.sendRedirect("catalogs");

        /*for (int i = 0; i < Database.cart.size(); ++i){
            ProductModel model = Database.cart.get(i);
            if (model.getId().equals(request.getParameter("productID"))){
                model.setPrice(model.getPrice() + Integer.parseInt(request.getParameter("price")));
                response.sendRedirect("catalogs");
                return;
            }
        }
        Database.cart.add(new ProductModel(request.getParameter("productID"), database.getProductNameByID(request.getParameter("productID")),
                Integer.parseInt(request.getParameter("price"))));
        System.out.println(request.getParameter("productID"));
        System.out.println(request.getParameter("price"));
        for (Cookie cookie1: request.getCookies()){
            if (cookie1.getName().equals(request.getParameter("productID"))){
                cookie1.setValue(String.valueOf(Integer.parseInt(cookie1.getValue()) + Integer.parseInt(request.getParameter("price"))));
                cookie1.setMaxAge(20);
                response.addCookie(cookie1);
                response.setStatus(200);
                return;
            }
        }
        Cookie cookie = new Cookie(request.getParameter("productID"), request.getParameter("price"));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        response.sendRedirect("catalogs");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database database = new Database();
        ArrayList<ProductModel> list = new ArrayList<>();
        for (Map.Entry<String, Integer> current: Database.cart1.entrySet()){
            list.add(new ProductModel(current.getKey(), database.getProductNameByID(current.getKey()), current.getValue()));
        }
        request.setAttribute("products", list);
        int total = 0;
        for (ProductModel model: list)
            total += model.getPrice();
        request.setAttribute("total", total);
        for (ProductModel model: list){
            System.out.println(model.getName());
        }
        Cookie cookie = new Cookie("visit", String.valueOf(getVisitTime(request) + 1));
        cookie.setMaxAge(20);
        response.addCookie(cookie);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    private int getVisitTime(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("visit")){
                return Integer.parseInt(cookie.getValue());
            }
        }
        return 0;
    }
}
