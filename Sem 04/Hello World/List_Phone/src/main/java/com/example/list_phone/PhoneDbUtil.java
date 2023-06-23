package com.example.list_phone;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PhoneDbUtil {
    private DataSource dataSource;
    public PhoneDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;}
    public List<Phone> getPhones() throws Exception {
        List<Phone> phones = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            String url = "jdbc:mysql://localhost:3306/phone_db";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "select * from phones order by name";

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                int id = myRs.getInt("id");
                String name = myRs.getString("name");
                String brand = myRs.getString("brand");
                String price = myRs.getString("price");
                String description = myRs.getString("description");

                Phone tempPhone = new Phone(id, name, brand, price, description);

                phones.add(tempPhone);
            }
            return phones;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try{
            if (myRs != null){
                myRs.close();
            }

            if (myStmt != null){
                myStmt.close();
            }

            if (myConn != null){
                myConn.close();
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public void addPhone(Phone thePhone) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/phone_db";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);

            String sql = "insert into phones" + "(name, brand, price,description)" + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setString(1, thePhone.getName());
            myStmt.setString(2, thePhone.getBrand());
            myStmt.setString(3, thePhone.getPrice());
            myStmt.setString(4, thePhone.getDescription());



            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
    public Phone getPhone(String theId) throws Exception{
        Phone thePhone = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int id;

        try{
            id = Integer.parseInt(theId);

            String url = "jdbc:mysql://localhost:3306/phone_db";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "select * from phones where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, id);

            myRs = myStmt.executeQuery();

            if (myRs.next()){
                String name = myRs.getString("name");
                String brand = myRs.getString("brand");
                String price = myRs.getString("email");
                String description = myRs.getString("description");




                thePhone = new Phone(id, name, brand, price,description);
            }
            else {
                throw new Exception("Could not find phone id: " + id);
            }
            return thePhone;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }
    public void deletePhone(String theId) throws Exception{
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            int id = Integer.parseInt(theId);

            String url = "jdbc:mysql://localhost:3306/phone_db";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection(url, username, password);

            String sql = "delete from phones where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, id);

            myStmt.execute();
        }
        finally {
            close(myConn, myStmt, null);
        }
    }
}

