import java.util.ArrayList;

public class Database {
    ArrayList<ProductModel> list;

    public Database() {
        this.list = new ArrayList<>();
        list.add(new ProductModel("iphone12", "iPhone 12", 520000, new CatalogModel("Gadgets")));
        list.add(new ProductModel("zara", "Zara", 20000, new CatalogModel("Clothes")));
        list.add(new ProductModel("burger", "Burger", 1000, new CatalogModel("Food")));
        list.add(new ProductModel("jacklondon", "Jack London", 3000, new CatalogModel("Books")));
    }

    public String getProductNameByID(String id){
        for (ProductModel model: list)
            if (model.getId().equals(id))
                return model.getName();
        return "";
    }


}
