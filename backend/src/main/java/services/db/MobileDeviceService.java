package services.db;

import models.MobileDevice;
import models.Person;

import java.sql.*;
import java.util.ArrayList;

public class MobileDeviceService {
    public MobileDevice getMobileDeviceByIccd(String id) throws SQLException {
        ArrayList<MobileDevice> mobileDevices = new ArrayList<MobileDevice>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM mobile_device WHERE iccd = '" + id + "'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        mobileDevices.add(
                                new MobileDevice(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3)

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
        return mobileDevices.toArray(new MobileDevice[0])[0];
    }

    public MobileDevice getMobileDeviceByPersonId(String id) throws SQLException {
        ArrayList<MobileDevice> mobileDevices = new ArrayList<MobileDevice>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM mobile_device WHERE personID = '" + id + "')";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        mobileDevices.add(
                                new MobileDevice(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getString(3)

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
        return mobileDevices.toArray(new MobileDevice[0])[0];
    }
}
