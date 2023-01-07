package me.ulearn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException, SQLException {
        SqliteDatabase.first();
        SqliteDatabase.second();
        SqliteDatabase.third();
    }

    public static ArrayList<Product> getProducts() throws IOException {
        var br = new BufferedReader(new FileReader("src\\main\\resources\\Продажа продуктов в мире.csv"));
        var products = new ArrayList<Product>();
        try {
            var head = br.readLine();
            var line = br.readLine();
            while (line != null) {
                products.add(new Product(line.split(",")));
                line = br.readLine();
            }

        } finally {
            br.close();
        }
        return products;
    }
}
