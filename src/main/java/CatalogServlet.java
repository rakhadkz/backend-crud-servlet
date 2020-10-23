import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CatalogServlet")
public class CatalogServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Database database = new Database();
        ArrayList<CatalogModel> list = new ArrayList<>();
        for (String s : database.catalogs2) {
            list.add(new CatalogModel(s));
        }
        list.sort(new CatalogComparator());

        request.setAttribute("catalogs", list);
        request.getRequestDispatcher("catalog.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Database database = new Database();
        if (session.getAttribute("login") == null){
            response.sendRedirect("login");
        }else{
            Queue<CatalogModel> catalogs = new LinkedList<>();
            for (String s : database.catalogs2) {
                catalogs.add(new CatalogModel(s));
            }
            request.setAttribute("catalogs", catalogs);
            request.getRequestDispatcher("catalog.jsp").forward(request, response);
        }
    }
}
