package me.ulearn;

import java.io.IOException;
import java.sql.*;

public class SqliteDatabase {

    public static void saveAll() throws SQLException, IOException {
        var productList = Program.getProducts();
        var connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\sqlite.db");
        var statement = connection.createStatement();
        statement.execute(
                "create table Products (region varchar,country varchar,itemType varchar,salesChannel varchar,orderPriority varchar,orderDate varchar,unitsSold int,totalProfit real);");

        for (int i = 0; i < productList.size(); i++) {
            var p = productList.get(i);
            p.save(statement);
        }
    }

    public static ResultSet execute(String sql) throws SQLException {
        var connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\sqlite.db");
        var statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public static void first() throws SQLException {
        var sql = "SELECT region,SUM(unitsSold) FROM Products GROUP BY region ORDER BY SUM(unitsSold)";
        var rs = SqliteDatabase.execute(sql);
        while(rs.next())
            System.out.println("1)"+rs.getString("region")+" "+rs.getString("SUM(unitsSold)"));
    }

    public static void second() throws SQLException {
        var sql = "SELECT *,SUM(totalProfit) FROM Products WHERE (region='Europe' or region='Asia') GROUP BY country ORDER BY SUM(totalProfit) DESC";
        var rs = SqliteDatabase.execute(sql);
        System.out.println("2)"+rs.getString("country"));
    }

    public static void third() throws SQLException {
        var sql = "SELECT * FROM Products " +
                "WHERE (region='Middle East and North Africa' or region='Sub-Saharan Africa') " +
                "AND totalProfit BETWEEN 420000 AND 440000\n" +
                "AND totalProfit = (SELECT MAX(totalProfit) AS M FROM Products " +
                "WHERE (region='Middle East and North Africa' or region='Sub-Saharan Africa')" +
                "AND totalProfit BETWEEN 420000 AND 440000 )";
        var rs = SqliteDatabase.execute(sql);
        System.out.println("3)"+rs.getString("country"));
    }

}
