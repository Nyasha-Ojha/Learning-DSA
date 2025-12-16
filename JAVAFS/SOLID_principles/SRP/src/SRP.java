import java.util.ArrayList;
import java.util.List;
class Product{
    public String productName;
    public double price;

    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }
}

class ShoppingCart{
    public List<Product> productsList = new ArrayList<>();

    public void addProducts(Product product){
        productsList.add(product);
    }

    public List<Product> getProduct(){
        return productsList;
    }

    public double calcTotalPrice(){
        double total = 0;
        for(Product p: productsList){
            total += p.price;
        }
        return total;
    }
}

class CartInvoicePrinter{
    private ShoppingCart sc;

    public CartInvoicePrinter(ShoppingCart sc){
        this.sc = sc;
    }
    public void printInvoice(){
        System.out.println("Invoice: ");
        for(Product p : sc.getProduct()){
            System.out.println(p.productName + "- Rs " + p.price);
        }
        System.out.println("Total price - " + sc.calcTotalPrice());
    }
}

class CartDBstorage{
    private ShoppingCart sc;
    public CartDBstorage(ShoppingCart sc){
        this.sc = sc;
    }

    public void saveToDB(){
        System.out.println("Data storage initiated");
        System.out.println("Data Stored To DB!");
    }
}

public class SRP {
    public static void main(String[] args) {

        ShoppingCart sc = new ShoppingCart();
        sc.addProducts(new Product("Comb", 99));
        sc.addProducts(new Product("Rice", 179.67));


        CartInvoicePrinter print1 = new CartInvoicePrinter(sc);
        print1.printInvoice();


        CartDBstorage save1 = new CartDBstorage(sc);
        save1.saveToDB();

    }
}