import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String name;
    private String location;
    private int age;


    //overloaded constructor
    public Driver(String name, String location, int age) {
        this.name = name;
        this.location = location;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", age=" + age +
                '}';
    }
}
