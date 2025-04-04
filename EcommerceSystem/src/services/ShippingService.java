package services;

import models.Product;
import models.Shippable;

import java.util.Map;

public class ShippingService {

    public static void shipItems(Map<Product, Integer> items) {
        double totalWeight = 0;

        // shipment notice
        System.out.println("** Shipment Notice **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product instanceof Shippable) {
                double weight = product.getWeight() * quantity;
                totalWeight += weight;
                System.out.println(quantity + "x " + product.getName() + " - " + weight + "kg");
            }
        }

        // Print the total package weight
        System.out.println("Total package weight: " + totalWeight + "kg");
    }
}
