package com.example.bms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController {

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField priceField;

    private final InventoryService inventoryService = new InventoryService();
    private ObservableList<Product> productList;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        productList = FXCollections.observableArrayList(inventoryService.getAllProducts());
        productTable.setItems(productList);
    }

    @FXML
    public void handleAddProduct() {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        Product product = new Product(0, name, quantity, price);
        inventoryService.addProduct(product);
        productList.setAll(inventoryService.getAllProducts());
    }

    @FXML
    public void handleUpdateProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            selectedProduct.setName(nameField.getText());
            selectedProduct.setQuantity(Integer.parseInt(quantityField.getText()));
            selectedProduct.setPrice(Double.parseDouble(priceField.getText()));
            inventoryService.updateProduct(selectedProduct);
            productList.setAll(inventoryService.getAllProducts());
        }
    }

    @FXML
    public void handleDeleteProduct() {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            inventoryService.deleteProduct(selectedProduct.getId());
            productList.setAll(inventoryService.getAllProducts());
        }
    }
}
