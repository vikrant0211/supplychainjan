package com.example.supplychainjan;

public class Order {
    public static boolean placeOrder(String customerEmail, Product product){
        DbConnection dbConnection = new DbConnection();
        String query = String.format("INSERT INTO orders (customer_id, product_id) VALUES ((SELECT customer_id FROM customer WHERE email = '%s'),%s)", customerEmail, product.getId());
        int rowCount = 0;
        try {
           rowCount = dbConnection.executeUpdateQuery(query);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rowCount!=0 ;
    }
}
