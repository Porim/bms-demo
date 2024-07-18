package com.example.bms;

import java.util.List;

public class InventoryService {
    private final ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) {
        productDAO.save(product);
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public void deleteProduct(int productId) {
        productDAO.delete(productId);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
}
