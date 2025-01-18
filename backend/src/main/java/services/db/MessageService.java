package services.db;

import models.Message;
import models.MobileDevice;

import java.sql.*;
import java.util.ArrayList;

public class MessageService {
    public Message[] getMessagesSentFromPerson(String id) throws SQLException {
        ArrayList<Message> messages = new ArrayList<Message>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM messages WHERE sender = '" + id + "' OR receiver = '" + id + "'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        messages.add(
                                new Message(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getDate(3)

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
        return messages.toArray(new Message[0]);
    }

    public Message[] getAllMessagesSentFromPersonToPerson(String senderId,String receiverId) throws SQLException {
        ArrayList<Message> messages = new ArrayList<Message>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM messages WHERE sender = '" + senderId+ "' AND receiver = '" + receiverId + "'";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        messages.add(
                                new Message(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getDate(3)

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
        return messages.toArray(new Message[0]);
    }


}
