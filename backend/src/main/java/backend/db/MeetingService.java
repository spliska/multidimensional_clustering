package backend.db;

import backend.models.Meeting;
import backend.models.Person;

import java.sql.*;
import java.util.ArrayList;

public class MeetingService {
    public Meeting[] getMeetings() {
        ArrayList<Meeting> meetings = new ArrayList<Meeting>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM phone_call";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        meetings.add(new Meeting(
                                        resultSet.getString(1),
                                        this.getMeetingParticipants(resultSet.getString(1)),
                                        resultSet.getInt(2),
                                        resultSet.getDouble(3),
                                        resultSet.getDouble(3),
                                        resultSet.getDouble(3),
                                        resultSet.getDate(4)
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
        return meetings.toArray(new Meeting[0]);
    }

    public Person[] getMeetingParticipants(String meetingId) {
        ArrayList<Person> participants = new ArrayList<Person>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM person WHERE id IN (SELECT person_id FROM meeting_participants WHERE meeting_id = '" + meetingId + "')";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        participants.add(new Person(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                new MobileDeviceService().getMobileDeviceByPersonId(resultSet.getString(1)))
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants.toArray(new Person[0]);
    }

    public Meeting[] getMeetingsBetween(String personOneId,String personTwoId) {

            ArrayList<Meeting> meetings = new ArrayList<Meeting>();
            Connection connection = null;
            try {
                connection = DriverManager.
                        getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
                try (Statement stmt = connection.createStatement()) {
                    String selectSql = "SELECT * FROM meeting WHERE meeting_id IN (SELECT meeting_id FROM meeting_participants WHERE person_id IN ("+personOneId+","+personTwoId+"))";
                    try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                        while (resultSet.next()) {
                            meetings.add(new Meeting(
                                            resultSet.getString(1),
                                            this.getMeetingParticipants(resultSet.getString(1)),
                                            resultSet.getInt(2),
                                            resultSet.getDouble(3),
                                            resultSet.getDouble(3),
                                            resultSet.getDouble(3),
                                            resultSet.getDate(4)
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
            return meetings.toArray(new Meeting[0]);
    }

    public Meeting[] getMeetingsBetweenInMonth(String personOneId,String personTwoId,Date startDate,Date endDate) {

        ArrayList<Meeting> meetings = new ArrayList<Meeting>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM meeting WHERE created_at >= startDate AND created_at <= endDate AND meeting_id IN (SELECT meeting_id FROM meeting_participants WHERE person_id IN ("+personOneId+","+personTwoId+"))";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        meetings.add(new Meeting(
                                        resultSet.getString(1),
                                        this.getMeetingParticipants(resultSet.getString(1)),
                                        resultSet.getInt(2),
                                        resultSet.getDouble(3),
                                        resultSet.getDouble(3),
                                        resultSet.getDouble(3),
                                        resultSet.getDate(4)
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
        return meetings.toArray(new Meeting[0]);
    }


}
