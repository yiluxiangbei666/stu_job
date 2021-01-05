package person.bean;

import java.io.Serializable;

public class subject implements Serializable {
    private String name;
    private int mount;

    public subject() {
    }

    public subject(String name, int mount) {
        this.name = name;
        this.mount = mount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return mount;
    }

    public void setAge(int mount) {
        this.mount = mount;
    }

    @Override
    public String toString() {
        return "subject{" +
                "name='" + name + '\'' +
                ", mount='" + mount + '\'' +
                '}';
    }
}
