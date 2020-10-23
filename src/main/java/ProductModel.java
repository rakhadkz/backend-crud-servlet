
public class ProductModel {
    private String id;
    private String name;
    private int price;
    private CatalogModel catalog;

    public ProductModel(String id, String name, int price, CatalogModel catalog) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.catalog = catalog;
    }

    public ProductModel(String id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductModel(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CatalogModel getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogModel catalog) {
        this.catalog = catalog;
    }
}
