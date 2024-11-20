package models;

public class Person {
    private String id;
    private String name;
    private MobileDevice mobileDevice;

    public Person(String id, String name, MobileDevice mobileDevice) {
        this.id = id;
        this.name = name;
        this.mobileDevice = mobileDevice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MobileDevice getMobileDevice() {
        return mobileDevice;
    }

    public void setMobileDevice(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }
}
