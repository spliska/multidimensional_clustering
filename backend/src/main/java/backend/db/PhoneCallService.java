package backend.db;

import backend.models.PhoneCall;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PhoneCallService {

    public PhoneCallService() {
    }

    public PhoneCall[] getAllPhoneCalls(){

        ArrayList<PhoneCall> phoneCalls=new ArrayList<PhoneCall>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM phone_call";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        phoneCalls.add(new PhoneCall(
                                resultSet.getDate(1),
                                resultSet.getTime(2),
                                resultSet.getTime(3),
                                resultSet.getString(4),
                                resultSet.getString(5)
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
        return phoneCalls.toArray(new PhoneCall[0]);
    }

    public PhoneCall[] getAllPhoneCallsByCallerId(String callerId){

        ArrayList<PhoneCall> phoneCalls=new ArrayList<PhoneCall>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM phone_call WHERE caller='"+callerId+"'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        phoneCalls.add(new PhoneCall(
                                        resultSet.getDate(1),
                                        resultSet.getTime(2),
                                        resultSet.getTime(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5)
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
        return phoneCalls.toArray(new PhoneCall[0]);
    }

    public PhoneCall[] getAllPhoneCallsByReceiverId(String receiverId  ){

        ArrayList<PhoneCall> phoneCalls=new ArrayList<PhoneCall>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM phone_call WHERE receiver='"+receiverId+"'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        phoneCalls.add(new PhoneCall(
                                        resultSet.getDate(1),
                                        resultSet.getTime(2),
                                        resultSet.getTime(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5)
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
        return phoneCalls.toArray(new PhoneCall[0]);
    }

    public PhoneCall[] getAllPhoneCallsBetweenTwoParties(String callerId, String receiverId){

        ArrayList<PhoneCall> phoneCalls=new ArrayList<PhoneCall>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM phone_call WHERE caller='"+receiverId+"' OR caller='"+callerId+"' AND receiver='"+receiverId+"' OR receiver='"+callerId+"'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        phoneCalls.add(new PhoneCall(
                                        resultSet.getDate(1),
                                        resultSet.getTime(2),
                                        resultSet.getTime(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5)
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
        return phoneCalls.toArray(new PhoneCall[0]);
    }

    public PhoneCall[] getAllPhoneCallsBetweenTwoPartiesWithinATimeFrame(String callerId, String receiverId, Date startDate,Date endDate){

        ArrayList<PhoneCall> phoneCalls=new ArrayList<PhoneCall>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM phone_call WHERE caller='"+receiverId+"' OR caller='"+callerId+"' AND receiver='"+receiverId+"' OR receiver='"+callerId+"' AND call_date BETWEEN "+startDate+" AND "+endDate;
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        phoneCalls.add(new PhoneCall(
                                        resultSet.getDate(1),
                                        resultSet.getTime(2),
                                        resultSet.getTime(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5)
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
        return phoneCalls.toArray(new PhoneCall[0]);
    }





}
