package backend.models;

import java.sql.Timestamp;
import java.util.UUID;

public class Movement {
    String id;
   String personId;
   Timestamp timestamp;
   double latitude;
   double longitude;
   String meetingId;

    public Movement(String personId, Timestamp timestamp, double latitude, double longitude, String meetingId) {
        this.id= UUID.randomUUID().toString();
        this.personId = personId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.meetingId = meetingId;
    }

    public Movement(String id,String personId, Timestamp timestamp, double latitude, double longitude, String meetingId) {
        this.id= id;
        this.personId = personId;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.meetingId = meetingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
