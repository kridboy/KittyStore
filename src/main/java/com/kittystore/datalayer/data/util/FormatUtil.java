package com.kittystore.datalayer.data.util;

public class FormatUtil {
    public static final String INSERT_BREED = "INSERT INTO Breeds(Breed_Name,Price) VALUES(?,?)";
    public static final String INSERT_BREEDER = "INSERT INTO Breeders(Breeder_Name,Contact,Phone) VALUES(?,?,?)";
    public static final String INSERT_CUSTOMER = "INSERT INTO Customers(First_Name,Last_Name,Address,Email) VALUES(?,?,?,?)";
    public static final String INSERT_ORDER = "INSERT INTO Orders(Customer_ID,Time_Stamp) VALUES(?,?)";
    public static final String INSERT_ITEM = "INSERT INTO Items(Order_ID,Breeder_ID,Breed_ID,Count) VALUES(?,?,?,?)";

    public static final String UPDATE_BREED = "UPDATE Breeds SET Breed_Name=?, Price=? WHERE ID=?";
    public static final String UPDATE_BREEDER = "UPDATE Breeders SET Breeder_Name=?, Contact=?, Phone=? WHERE ID=?";
    public static final String UPDATE_CUSTOMER = "UPDATE Customers SET First_Name=?, Last_Name=?, Address=?, Email=? WHERE ID=?";
    public static final String UPDATE_ITEM = "UPDATE Items SET Count=?  WHERE ID=?";

    public static final String REMOVE_BREED = "DELETE FROM Breeds WHERE ID=?";
    public static final String REMOVE_BREEDER = "DELETE FROM Breeders WHERE ID=?";
    public static final String REMOVE_BREEDER_INVENTORY="DELETE FROM Breeder_Inventory WHERE Breeder_ID=?";
    public static final String REMOVE_ORDER = "DELETE FROM Orders WHERE ID=?";
    public static final String REMOVE_ITEM = "DELETE FROM Items WHERE ID=?";

    public static final String SELECT_BREED_BY_ID = "SELECT * FROM Breeds WHERE ID=?";
    public static final String SELECT_BREEDER_BY_ID = "SELECT * FROM Breeders WHERE ID=?";
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customers WHERE ID=?";
    public static final String SELECT_ITEM_BY_ID = "SELECT * FROM Items WHERE ID=?";
    public static final String SELECT_ORDER_BY_ID = "SELECT * FROM Orders WHERE ID=?";
    public static final String SELECT_BREED_BY_NAME = "SELECT * FROM Breeds WHERE Name=?";
    public static final String SELECT_BREEDER_BY_NAME = "SELECT * FROM Breeders WHERE Name=?";

}
