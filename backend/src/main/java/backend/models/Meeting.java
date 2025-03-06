package backend.models;

import backend.clustering.GpsDistanceCalculator;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Meeting {
    private String meeting_id;
    private Person[] people;
    private int duration;
    private double longitude;
    private double latitude;
    private double distance;
    private Date date;

    public Meeting(String meeting_id, Person[] people, int duration, double longitude, double latitude, double distance, Date date) {
        this.meeting_id = meeting_id;
        this.people = people;
        this.duration = duration;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.date = date;
    }

    public Meeting( Person[] people, int duration, double longitude, double latitude, double distance, Date date) {
        this.meeting_id = UUID.randomUUID().toString();
        this.people = people;
        this.duration = duration;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.date = date;
    }

    public Meeting( int duration, double longitude, double latitude, double distance, Date date) {
        this.meeting_id = UUID.randomUUID().toString();
        this.people = null;
        this.duration = duration;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
        this.date = date;
    }

    public static String  generateMeetingId(){
        return UUID.randomUUID().toString();
    }

    public void calculateAndAddDistance(double latOne, double lonOne, double latTwo, double lonTwo) {
        this.distance = new GpsDistanceCalculator().calculateDistance(latOne, lonOne, latTwo, lonTwo);
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people.toArray(new Person[people.size()]);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(String meeting_id) {
        this.meeting_id = meeting_id;
    }
}
