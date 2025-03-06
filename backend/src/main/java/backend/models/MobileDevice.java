package backend.models;

public class MobileDevice {
    String iccd;
    String deviceType;
    String personID;

    public MobileDevice(String iccd, String deviceType, String personID) {
        this.iccd = iccd;
        this.deviceType = deviceType;
        this.personID = personID;
    }

    public String getIccd() {
        return iccd;
    }

    public void setIccd(String iccd) {
        this.iccd = iccd;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
}
