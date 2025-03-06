package backend.db;

import backend.models.Movement;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class MovementDataService {
    double maxEncounterDistance;

    public MovementDataService(double maxEncounterDistance) {
        this.maxEncounterDistance = maxEncounterDistance;
    }

    public MovementDataService() {
        this.maxEncounterDistance = 1.0;
    }

    public ArrayList<Movement> getMovementDataOfPerson(String personId) throws SQLException {
        ArrayList<Movement> movementData = new ArrayList<Movement>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM person_gps_location_data WHERE personID = '" + personId + "'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        movementData.add(
                                new Movement(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getTimestamp(3),
                                        resultSet.getDouble(4),
                                        resultSet.getDouble(5),
                                        resultSet.getString(6)


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
        return movementData;
    }

    public ArrayList<Movement> getMovementOfLocationAndTimestamp(double latitude, double longitude, Timestamp start_date_time, Timestamp end_date_time) throws SQLException {
        ArrayList<Movement> movementData = new ArrayList<Movement>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM person_gps_location_data AND date_time BETWEEN \'" + start_date_time + "\' AND \'" + end_date_time + "\' AND ST_Distance_Sphere(point(longitude,latitude),point(" + longitude + "," + latitude + ")) <" + maxEncounterDistance + "";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        movementData.add(
                                new Movement(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getTimestamp(3),
                                        resultSet.getDouble(4),
                                        resultSet.getDouble(5),
                                        resultSet.getString(6)


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
        connection.close();
        return movementData;
    }

    public ArrayList<Movement> getMovementOfLocationAndTimestamp(String personId, double latitude, double longitude, Timestamp start_date_time, Timestamp end_date_time) throws SQLException {
        ArrayList<Movement> movementData = new ArrayList<Movement>();
        Connection connection = null;
        System.out.println("SELECT * FROM person_gps_location_data WHERE personID != " + personId + " AND date_time BETWEEN \'" + start_date_time + "\' AND \'" + end_date_time + "\' AND ST_Distance_Sphere(point(longitude,latitude),point(" + longitude + "," + latitude + ")) <" + maxEncounterDistance + "");
        System.out.println("SELECT * FROM person_gps_location_data WHERE personID != " + personId + " AND date_time BETWEEN \'" + start_date_time + "\' AND \'" + end_date_time + "\' AND ST_Distance_Sphere(point(longitude,latitude),point(" + longitude + "," + latitude + ")) <" + maxEncounterDistance + "");
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM person_gps_location_data WHERE personID != " + personId + " AND date_time BETWEEN \'" + start_date_time + "\' AND \'" + end_date_time + "\' AND ST_Distance_Sphere(point(longitude,latitude),point(" + longitude + "," + latitude + ")) <" + maxEncounterDistance + "";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        movementData.add(
                                new Movement(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getTimestamp(3),
                                        resultSet.getDouble(4),
                                        resultSet.getDouble(5),
                                        resultSet.getString(6)


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
        return movementData;
    }

    public Boolean insertMovement(String movementId, String personID, Timestamp date_time, Double latitude, Double longitude, String meetingId) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String insertSql = "INSERT INTO `person_gps_location_data`(`movementId`,`personID`, `date_time`, `latitude`, `longitude`, `meetingId`) VALUES ('" + movementId + "','" + personID + "','" + date_time + "','" + latitude + "','" + longitude + "')";
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(insertSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public Boolean insertMovement(String personID, Timestamp date_time, Double latitude, Double longitude, String meetingId) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String insertSql = "INSERT INTO `person_gps_location_data`(`movementId`,`personID`, `date_time`, `latitude`, `longitude`, `meetingId`) VALUES ('" + UUID.randomUUID().toString() + "','" + personID + "','" + date_time + "','" + latitude + "','" + longitude + "')";
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(insertSql);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public Boolean updateMovement(String movementId, String meetingId) throws SQLException {
        Connection connection = null;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");

        String sql = "UPDATE person_gps_location_data SET meetingId = '" + meetingId + "' WHERE movementId ='" + movementId + "'";
        System.out.println(sql);

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}



