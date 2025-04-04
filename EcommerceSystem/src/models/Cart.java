package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();


    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        if (product instanceof Expirable && ((Expirable) product).isExpired()) {
            throw new IllegalStateException(product.getName() + " is expired.");
        }

        // Update the CArt or Ypdate the quantity if it's already in it
        items.put(product, items.getOrDefault(product, 0) + quantity);

        // Reduce the available stock of the product
        product.reduceQuantity(quantity);
    }


    // Returns the map of products and their quantities
    public Map<Product, Integer> getItems() {
        return items;
    }

    // Checks if the cart is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
