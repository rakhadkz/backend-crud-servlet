import java.util.*;

public class Database {
    LinkedList<ProductModel> list;
    HashSet<String> catalogs2 = new HashSet<>();

    public static String[] catalogs = {"Sport", "Sport", "Furniture", "Gadgets", "Clothes", "Beauty", "Music", "Books", "Food", "Home store", "Jewelry"};
    public Database() {
        this.list = new LinkedList<>();
        list.add(new ProductModel("iphone12", "iPhone 12", 520000, new CatalogModel("Gadgets")));
        list.add(new ProductModel("zara", "Zara", 20000, new CatalogModel("Clothes")));
        list.add(new ProductModel("burger", "Burger", 1000, new CatalogModel("Food")));
        list.add(new ProductModel("jacklondon", "Jack London", 3000, new CatalogModel("Books")));
        catalogs2.addAll(Arrays.asList(catalogs));
    }

    public static Map<String, Integer> cart1 = new HashMap<>();

    public String getProductNameByID(String id){
        for (ProductModel model: list)
            if (model.getId().equals(id))
                return model.getName();
        return "";
    }


}
