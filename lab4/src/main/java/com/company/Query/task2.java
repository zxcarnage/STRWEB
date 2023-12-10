package com.company.Query;
import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String name ="VADioG";
            String sql = "INSERT INTO Publishers (publisherName)" + "VALUES ('" + name + "')";
            stmt.executeUpdate(sql);
            System.out.println("Добавлен новый издатель");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }

    }
}
