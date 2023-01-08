package com.example.supplychainjan;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;


public class Login {

    private byte[] getSHA(String input){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

   private String getEncryptedPassword(String Password){
        try {
            BigInteger number = new BigInteger(1, getSHA(Password));
            StringBuilder hexString = new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean customerLogin (String Email, String Password){
        String query = String.format("SELECT * FROM customer WHERE Email = '%s' AND Password = '%s' " ,Email, Password);
        try {
            DbConnection dbConn = new DbConnection();
            ResultSet rs = dbConn.getQueryTable(query);
            if (rs != null && rs.next()) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }

//    public static void main(String[] args) {
//        Login login = new Login();
//        System.out.println(login.customerLogin("vikrant@123", "yadav"));
//   }
//public static void main(String[] args) {
//    Login login = new Login();
//    System.out.println(login.getEncryptedPassword("Abc123"));
//}

}
