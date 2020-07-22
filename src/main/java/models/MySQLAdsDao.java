package models;

import com.mysql.cj.jdbc.Driver;
import models.Ad;
import models.Ads;
import models.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            while(rs.next()) {
                System.out.println(rs.getLong("id"));
                System.out.println(rs.getString("title"));
                System.out.println(rs.getString("description"));
                ads.add(new Ad(rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        long lastInsertedId = 0;
        String insertQuery = String.format(
                "INSERT INTO ads (user_id, title,description) VALUES (%d,'%s','%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()

        );
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format(insertQuery, Statement.RETURN_GENERATED_KEYS));
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            lastInsertedId =  rs.getLong(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastInsertedId;
    }

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(config.getURL(),config.getUser(),config.getPassword());
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
