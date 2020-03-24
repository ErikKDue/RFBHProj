package businesslayer;

import java.util.ArrayList;

public class employee extends person {

    boolean adminRights;
    ArrayList<String> fraværsdage = new ArrayList<>();

    public employee(String name, String lastName, String address, boolean adminRights, ArrayList<String> fraværsdage) {
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
}
