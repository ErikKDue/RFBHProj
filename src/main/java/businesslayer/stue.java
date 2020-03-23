import java.util.ArrayList;

public class stue
{
    public String name;
    ArrayList<String> børn = new ArrayList<>();
    ArrayList<String> ansat = new ArrayList<>();

    public void createTelefonliste()
    {


    }

    public stue(String name, ArrayList<String> børn, ArrayList<String> ansat) {
        this.name = name;
        this.børn = børn;
        this.ansat = ansat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
