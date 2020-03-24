package businesslayer;

public class Parent extends Person {


    int telefon;
    String email;

    public Parent(String name, String lastName, String address, int telefon, String email) {
        super(name, lastName, address);
        this.telefon = telefon;
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "parent{" +
                "telefon=" + telefon +
                ", email='" + email + '\'' +
                '}';
    }
}
