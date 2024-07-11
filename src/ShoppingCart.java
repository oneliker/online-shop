import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Product product : products) {
            System.out.println(product.getProductName() + " - $" + product.getPrice() + " x " + product.getQuantity());
        }
        System.out.println("Total: $" + calculateTotal());
    }

    public List<Product> getProducts() {
        return products;
    }
}
