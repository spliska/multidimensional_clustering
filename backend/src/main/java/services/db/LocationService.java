package services.db;

import models.Location;
import models.PhoneCall;

import java.sql.*;
import java.util.ArrayList;

public class LocationService {
    public Location[] getAllLocations(){
        ArrayList<Location> locations=new ArrayList<Location>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM location";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        locations.add(new Location(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getDouble(6),
                                        resultSet.getDouble(7)
                                )
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations.toArray(new Location[0]);
    }

}
