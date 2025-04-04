import models.*;
import services.CheckoutService;
import services.ShippingService;
// My Main code that provides  a valid checkout service without any errors
public class Main {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 200, 5, false, 0.4);
        Product tv = new TV("TV", 5000, 2, 10);
        Product scratchCard = new MobileScratchCard("Scratch Card", 50, 10);

        Customer customer = new Customer("Amr", 10000);
        Cart cart = new Cart();

        cart.add(tv, 1);
        cart.add(scratchCard, 1);
        cart.add(cheese,4);
        // Proceed to checkout
        CheckoutService.checkout(customer, cart);

    }
}
