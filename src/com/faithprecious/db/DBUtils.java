package com.faithprecious.db;

import java.sql.*;

/**
 * Created by faithpercious on 2017/9/27.
 */
public class DBUtils {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/Girls";
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {



    }
}
