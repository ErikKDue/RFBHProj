package businesslayer;

import java.util.Arrays;

public class Child extends Person {

    public int age;
    Parent[] Parents = new Parent[4];

    public Child(String name, String lastName, String address, int age, Parent[] Parents) {
        super(name, lastName, address);
        this.age = age;
        this.Parents = Parents;
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
}
