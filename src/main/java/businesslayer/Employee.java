package businesslayer;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;

@JsonTypeName("Employee")
public class Employee extends Person {

    boolean adminRights;
    ArrayList<String> fraværsdage = new ArrayList<>();

    public Employee(String name, String lastName, String address, boolean adminRights, ArrayList<String> fraværsdage) {
        super(name, lastName, address);
        this.adminRights = adminRights;
        this.fraværsdage = fraværsdage;
    }

    public boolean isAdminRights() {
        return adminRights;
    }

    public void setAdminRights(boolean adminRights) {
        this.adminRights = adminRights;
    }

    public ArrayList<String> getFraværsdage() {
        return fraværsdage;
    }

    public void setFraværsdage(ArrayList<String> fraværsdage) {
        this.fraværsdage = fraværsdage;
    }

    @Override
    public String toString() {
        return "employee{" +
                "adminRights=" + adminRights +
                ", fraværsdage=" + fraværsdage +
                '}';
    }

    @Override
    public String getStorageObjectType() {
        return "Employee";
    }
}
