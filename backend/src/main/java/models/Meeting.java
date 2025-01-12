package models;

import clustering.DistanceCalculator;

import java.sql.Date;

public class Meeting {
    private Person[] people;
    private int duration;
    private double longitude;
    private double latitude;
    private double distance;
    private Date date;

    public Meeting(Person[] people, int duration, double longitude, double latitude, double distance) {
        this.people = people;
        this.duration = duration;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = distance;
    }

    public void calculateAndAddDistance(double latOne, double lonOne, double latTwo, double lonTwo) {
        this.distance = new DistanceCalculator().calculateDistance(latOne, lonOne, latTwo, lonTwo);
    }

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
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
}
