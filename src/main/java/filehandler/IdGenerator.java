package filehandler;

public class IdGenerator {

    public String generateId(String valueToGenerateFrom) {
        return Integer.toString(valueToGenerateFrom.hashCode());
    }
}
