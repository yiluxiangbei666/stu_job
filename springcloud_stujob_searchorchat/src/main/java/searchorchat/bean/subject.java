package searchorchat.bean;

import java.io.Serializable;

public class subject implements Serializable {
    private String name;
    private int age;

    public subject() {
    }

    public subject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "subject{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
