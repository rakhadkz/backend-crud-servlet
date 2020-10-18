import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("catalog", request.getParameter("catalog"));
        request.setAttribute("products", getList(request.getParameter("catalog")));
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    private ArrayList<ProductModel> getList(String catalog){
        ArrayList<ProductModel> list = new ArrayList<>();
        for (ProductModel model: productList()){
            if (model.getCatalog().getName().equals(catalog)){
                list.add(model);
            }
        }
        if (list.size() > 0)
            return list;
        return null;
    }

    private ArrayList<ProductModel> productList(){
        return new Database().list;
    }
}
