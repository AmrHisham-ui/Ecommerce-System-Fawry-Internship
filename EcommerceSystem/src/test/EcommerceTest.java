package test;

import models.*;
import services.CheckoutService;
import services.ShippingService;
// 5 test cases (unit testing )
public class EcommerceTest {

    public static void main(String[] args) {
        testCheckoutWithItemsInTheCart();
        testCheckoutWithEmptyCart();
        testCheckoutWithInsufficientBalance();
        testCheckoutWithExpiredProduct();
        testCheckoutWithOutOfStockProduct();
    }

    // Test 1: Checkout with Items in the Cart
    public static void testCheckoutWithItemsInTheCart() {
        Product cheese = new Cheese("Cheese", 200, 5, false, 0.4);
        Product tv = new TV("TV", 5000, 2, 10);
        Customer customer = new Customer("amr", 10000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv, 1);

        CheckoutService.checkout(customer, cart);
    }

    // Test case 2: Cart is Empty
    public static void testCheckoutWithEmptyCart() {
        try {
            Cart cart = new Cart();
            Customer customer = new Customer("ahmed", 10000);
            CheckoutService.checkout(customer, cart);
        } catch (IllegalStateException e) {
            System.out.println("Test 2: Cart is Empty - " + e.getMessage());
        }
    }

    // Test case 3: Insufficient Balance
    public static void testCheckoutWithInsufficientBalance() {
        try {
            Product cheese = new Cheese("Cheese", 200, 5, false, 0.4);
            Product tv = new TV("TV", 5000, 2, 10);
            Customer customer = new Customer("mohamed", 1000);  // Insufficient balance
            Cart cart = new Cart();

            cart.add(cheese, 2);
            cart.add(tv, 1);
            CheckoutService.checkout(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3: Insufficient Balance - " + e.getMessage());
        }
    }

    // Test case 4: Expired Product
    public static void testCheckoutWithExpiredProduct() {
        try {
            Product cheese = new Cheese("Cheese", 200, 5, true, 0.4);  // Expired product
            Customer customer = new Customer("ahmed", 10000);
            Cart cart = new Cart();
            cart.add(cheese, 2);
            CheckoutService.checkout(customer, cart);
        } catch (IllegalStateException e) {
            System.out.println("Test 4: Expired Product - " + e.getMessage());
        }
    }

    // Test case 5: Out of Stock Product
    public static void testCheckoutWithOutOfStockProduct() {
        try {
            Product cheese = new Cheese("Cheese", 200, 3, false, 0.4);  // Only 3 items available
            Customer customer = new Customer("mohamed", 10000);
            Cart cart = new Cart();
            cart.add(cheese, 5);  // Exceeds available stock
            CheckoutService.checkout(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 5: Out of Stock Product - " + e.getMessage());
        }
    }
}
