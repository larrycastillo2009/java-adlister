import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    @Override
    public List<Ad> all() {
        List<Ad> ads =new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");
            while(rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("phone_number")
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
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format("INSERT INTO contacts (name, description) VALUES ('%s', '%s')", Ad.getTitle(), Ad.getDescription()), Statement.RETURN_GENERATED_KEYS);
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
