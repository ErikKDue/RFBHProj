package businesslayer;

import filehandler.IStorageObject;

public class Person implements IStorageObject {

    String name;
    String lastName;
    String address;

    public Person(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public Person() {

    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public String getIdString() {
        return name + " " + lastName;
    }

    @Override
    public String getStorageObjectType() {
        return "Person";
    }

}
