package com.example.budgettrackermysql.data;

import com.example.budgettrackermysql.model.BudgetTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BudgetTrackerDao {

    public int insertBudgetTrackerDB(BudgetTracker budgetTracker) throws SQLException {
        Connection con = null;  // DBコネクション

        Statement smt = null;   // SQLステートメント

        int rowsCount = 0;

        con= DriverManager.getConnection("jdbc:mysql://192.168.0.32:3306/budgettracker?characterEncoding=utf8","and_user","android0216");
//        con= DriverManager.getConnection("jdbc:mysql://192.168.0.32:3306/budgettracker","and_user","android0216");
        smt=con.createStatement();
//        ResultSet rs=smt.executeQuery("select * from 2019_records");

        String insertSQL = "INSERT INTO 2019_records(id, date, storename, productname, type, price) " +
        "VALUES('" + budgetTracker.getId() + "','" + budgetTracker.getDate() + "'," + budgetTracker.getStoreName() + "'," + budgetTracker.getProductName() + "'," + budgetTracker.getType() + "'," + budgetTracker.getPrice() +")";

        // SQL文発行
        rowsCount = smt.executeUpdate(insertSQL);
        return rowsCount;
    }

}
