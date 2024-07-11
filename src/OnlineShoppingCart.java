import java.util.Scanner;

public class OnlineShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("John Doe", "123 Main St");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Online Shopping Cart Menu ---");
            System.out.println("1. Add product to cart");
            System.out.println("2. Remove product from cart");
            System.out.println("3. Display cart");
            System.out.println("4. Calculate total");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Product product = new Product(name, price, quantity);
                    customer.getShoppingCart().addProduct(product);
                    System.out.println("Product added to cart.");
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String productNameToRemove = scanner.nextLine();
                    boolean removed = false;
                    for (Product prod : customer.getShoppingCart().getProducts()) {
                        if (prod.getProductName().equals(productNameToRemove)) {
                            customer.getShoppingCart().removeProduct(prod);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        System.out.println("Product removed from cart.");
                    } else {
                        System.out.println("Product not found in cart.");
                    }
                    break;
                case 3:
                    customer.getShoppingCart().displayCart();
                    break;
                case 4:
                    double total = customer.getShoppingCart().calculateTotal();
                    System.out.println("Total: $" + total);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
