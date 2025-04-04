package models;

public class MobileScratchCard extends Product {
    public MobileScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double getWeight() {
        return 0; // it has 0 weight in the pdf
    }
}
