package businesslayer;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("Child")
public class Child extends Person {

    public int age;
    public int year;
    Parent[] Parents = new Parent[4];

    public Child(String name, String lastName, String address, int year, Parent[] Parents) {
        super(name, lastName, address);
        this.year = year;
        this.Parents = Parents;
    }

    public Child() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Parent[] getParents() {
        return Parents;
    }

    public void setParents(Parent[] Parents) {
        this.Parents = Parents;
    }

    @Override
    public String toString() {
        return "child{" +
                "age=" + age +
                ", parents=" + Arrays.toString(Parents) +
                '}';
    }

    @Override
    public String getIdString() {
        return name + " " + lastName + " " + year;
    }

    @Override
    public String getStorageObjectType() {
        return "Child";
    }
}
