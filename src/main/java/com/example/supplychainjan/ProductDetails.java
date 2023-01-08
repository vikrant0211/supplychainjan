package com.example.supplychainjan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ProductDetails {
    public TableView<Product> productTable;

    public Pane getAllProducts () {
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<Product> data = FXCollections.observableArrayList();
//        data.add(new Product(1, "Lenovo", 1999.9));
//        data.add(new Product(2, "Samsung", 29999.9));
//        data.add(new Product(3, "HP", 3999.9));

        ObservableList<Product> products = Product.getProducts();

        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);
        productTable.setMinSize(SupplyChain.width, SupplyChain.height-SupplyChain.headerBar);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Pane tablePane = new Pane();
//        tablePane.setTranslateX(40);
//        tablePane.setTranslateY(20);
        tablePane.getChildren().add(productTable);

        return tablePane;
    }

    public Pane getProductsByName(String productName) {
        TableColumn id = new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<Product> data = FXCollections.observableArrayList();
//        data.add(new Product(1, "Lenovo", 1999.9));
//        data.add(new Product(2, "Samsung", 29999.9));
//        data.add(new Product(3, "HP", 3999.9));

        ObservableList<Product> products = Product.getProductsByName(productName);

        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);
        productTable.setMinSize(SupplyChain.width, SupplyChain.height-SupplyChain.headerBar);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Pane tablePane = new Pane();
//        tablePane.setTranslateX(40);
//        tablePane.setTranslateY(20);
        tablePane.getChildren().add(productTable);

        return tablePane;
    }

    public Product getSelectedProduct() {
        Product product = new Product(1,"watch", 2000.00);

        return product;
    }
}