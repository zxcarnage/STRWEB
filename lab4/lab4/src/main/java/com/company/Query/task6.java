package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.company.Connection.JDBC.connection;

public class task6
{
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            Scanner in = new Scanner(System.in);
            System.out.println("Введите id автора, которому надо изменить имя");
            int newID = in.nextInt();
            System.out.println("Введите новое имя: ");
            String newName = in.next();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE authors SET firstName = ? WHERE authorID = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newID);
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }

    }
}
