package backend.models;

public class Person {
    private String id;
    private String firstName;
    private String name;
    private String city;
    private MobileDevice mobileDevice;

    public Person(String id, String firstName, String name, String city, MobileDevice mobileDevice) {
        this.id = id;
        this.firstName = firstName;
        this.name = name;
        this.city = city;
        this.mobileDevice = mobileDevice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public MobileDevice getMobileDevice() {
        return mobileDevice;
    }

    public void setMobileDevice(MobileDevice mobileDevice) {
        this.mobileDevice = mobileDevice;
    }
}
