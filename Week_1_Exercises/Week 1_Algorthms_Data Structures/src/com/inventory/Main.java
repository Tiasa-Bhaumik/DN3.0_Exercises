package com.inventory;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Create products
        Product product1 = new Product(1, "Laptop", 10, 999.99);
        Product product2 = new Product(2, "Smartphone", 20, 499.99);

        // Add products
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Update a product
        product1.setPrice(899.99);
        inventory.updateProduct(product1);

        // Find and display a product
        Product foundProduct = inventory.findProduct(1);
        if (foundProduct != null) {
            System.out.println("Product ID: " + foundProduct.getProductId());
            System.out.println("Product Name: " + foundProduct.getProductName());
            System.out.println("Quantity: " + foundProduct.getQuantity());
            System.out.println("Price: " + foundProduct.getPrice());
        }

        // Delete a product
        inventory.deleteProduct(2);

        // Try finding the deleted product
        Product deletedProduct = inventory.findProduct(2);
        if (deletedProduct == null) {
            System.out.println("Product not found.");
        }
    }
}

