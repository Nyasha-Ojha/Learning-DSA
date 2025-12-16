import java.util.*;

class Product2{

    int cartNumber;
    public String productName;
    public double price;

    public Product2(int cartNumber, String productName, double price){
        this.cartNumber = cartNumber;
        this.productName = productName;
        this.price = price;
    }
}
class ShoppingCart2{
    public List<Product2> product2sList = new ArrayList<>();

    public void addProducts(Product2 prod){
        product2sList.add(prod);
    }
    public List<Product2> getProducts2(){
        return product2sList;
    }

    public double calcTotalPrice(){
        double total = 0;
        for(Product2 prod : product2sList){
            total += prod.price;
        }
        return total;
    }
}

class CartInvoicePrinter2{
    private ShoppingCart2 cart;

    public CartInvoicePrinter2(ShoppingCart2 cart){
        this.cart = cart;
    }

    public void printInvoice(){
        System.out.println("Invoice: ");
        for(Product2 prod : cart.product2sList){
            System.out.println(prod.productName + "- Rs" + prod.price);
        }
    }
}

interface Persistence{
    void save(ShoppingCart2 cart);
}

class SQLpersistence implements Persistence{
    @Override
    public void save(ShoppingCart2 cart){
        System.out.println("data stored to the SQL server");
    }
}
class Mongopersistence implements Persistence{
    @Override
    public void save(ShoppingCart2 cart){
        System.out.println("data stored to the Mongo server");
    }
}
class Filepersistence implements Persistence{
    @Override
    public void save(ShoppingCart2 cart){
        System.out.println("data stored to the File-based server");
    }
}
public class OCP {
    public static void main(String[] args) {
        ShoppingCart2 cart2 = new ShoppingCart2();
        cart2.addProducts(new Product2(1, "Rava", 128.34));
        cart2.addProducts(new Product2(1, "Dog Food", 278));



        CartInvoicePrinter2 print = new CartInvoicePrinter2(cart2);
        print.printInvoice();

        System.out.println("Total Price: Rs" + cart2.calcTotalPrice());

        System.out.println();
        Persistence db = new SQLpersistence();
        Persistence mongo = new Mongopersistence();
        Persistence file = new Filepersistence();

        db.save(cart2);
        mongo.save(cart2);
        file.save(cart2);

    }
}
