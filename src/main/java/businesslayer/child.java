package businesslayer;

import java.util.ArrayList;
import java.util.Arrays;

public class child extends person {

    public int age;
    parent[] parents = new parent[4];

    public child(String name, String lastName, String address, int age, parent[] parents) {
        super(name, lastName, address);
        this.age = age;
        this.parents = parents;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public parent[] getParents() {
        return parents;
    }

    public void setParents(parent[] parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "child{" +
                "age=" + age +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }
}
