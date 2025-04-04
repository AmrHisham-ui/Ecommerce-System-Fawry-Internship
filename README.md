# Ecommerce System (Java-based)

This is a simple Java-based Ecommerce System that includes essential features like product management, shopping cart, checkout, and shipping services. The system supports various types of products, including expired and non-expired products, shippable and non-shippable items. It also includes error handling to ensure smooth user experience and robust system performance.

## Features:
- **Product Management**: Define products with details like name, price, quantity, and expiration.
- **Cart Management**: Add products to the cart, ensuring valid quantity and stock.
- **Checkout**: Calculate order subtotal, shipping fees, and total amount. Ensure customer has sufficient balance and handle errors for out-of-stock or expired products.
- **Shipping**: Collect shippable items and send them to a shipping service with relevant weight details.
- **Error Handling**: Ensures the system handles common errors like empty cart, insufficient balance, and expired products.

## Technology Stack:
- **Language**: Java
- **Concepts Used**: Object-Oriented Programming (OOP)
- **Data Structures**: HashMap for Cart items

## Instructions to Run:
1. Clone the repository.
2. Compile and run the `Main.java` class.
3. Follow the prompts to test different scenarios (e.g., checkout, adding products to the cart, etc.).

## How to Use:
- Add products to the cart with specific quantities.
- Perform a checkout to see the total price and shipping fees.
- Errors will be thrown if the cart is empty, if there is insufficient balance, or if any product is out of stock or expired.

## Example Output:
