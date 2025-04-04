package services;

import models.Cart;
import models.Customer;
import models.Product;
import models.Shippable;

import java.util.Map;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty() || cart.getItems().values().stream().allMatch(quantity -> quantity == 0)) {
            throw new IllegalStateException("Cart is empty. Please add items to your cart before proceeding.");
        }

        double subtotal = 0;
        double shipping = 0;

        // Calculating subtotal
        System.out.println("** Checkout Receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (quantity > 0) {  // Only process products that have a positive quantity
                double productTotal = product.getPrice() * quantity;
                subtotal += productTotal;

                // Print each product and its total price (price * quantity)
                System.out.println(quantity + "x " + product.getName() + " - " + productTotal);

                // If the product is shippable, calculate the shipping cost
                if (product instanceof Shippable) {
                    shipping += ((Shippable) product).getWeight() * quantity * 10; // Weight * rate (10)
                }
            }
        }

        //total cost
        double total = subtotal + shipping;

        // Check if customer has enough balance
        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Insufficient balance. You need " + (total - customer.getBalance()) + " more.");
        }

        // Deducted balance from customer account
        customer.deductBalance(total);

        //  summary
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Total: " + total);
        System.out.println("Remaining Balance: " + customer.getBalance());

        // Send items to the shipping service (only if they are shippable) by using the static feature
        ShippingService.shipItems(cart.getItems());

    }
}
