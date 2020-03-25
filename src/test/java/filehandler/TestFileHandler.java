package filehandler;

import businesslayer.Child;
import businesslayer.Parent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TestFileHandler {

    @Test
    public void test_this() {
        System.out.println("HEllo This");
    }

    //bøøh

    @Test
    public void testSaveIStorageObject() {
        CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());
    }

    private HashMapHandler CreateTestChildrenAndAddThemToHashMaps(HashMapHandler hashMapHandler) {
        Parent[] parents = new Parent[2];
        // try and save it
        FileHandler fileHandler = new FileHandler();
        Child child = new Child("Test", "Child", "bar", 17, parents);
        Child child2 = new Child("Tester", "Child2", "Rumlebef", 12, parents);
        fileHandler.WriteToNewFile(child, "Child");
        Child child3 = new Child("Mark", "Markusson", "Mellemved", 11, parents);
        fileHandler.WriteToNewFile(child, "Child");
        Child child4 = new Child("Alex", "Torsson", "Mellemved", 9, parents);
        fileHandler.WriteToNewFile(child, "Child");
        Child child5 = new Child("Alice", "Alisson", "Oslo", 7, parents);
        fileHandler.WriteToNewFile(child, "Child");
        fileHandler.WriteToNewFile(child2, "Child");
        fileHandler.WriteToNewFile(child3, "Child");
        fileHandler.WriteToNewFile(child4, "Child");
        fileHandler.WriteToNewFile(child5, "Child");
        hashMapHandler.addValueToMap("C:\\Work\\" + child.getName(), "file", "1");
        hashMapHandler.addValueToMap("C:\\Work\\" + child2.getName(), "file", "2");
        hashMapHandler.addValueToMap("C:\\Work\\" + child3.getName(), "file", "3");
        hashMapHandler.addValueToMap("C:\\Work\\" + child4.getName(), "file", "4");
        hashMapHandler.addValueToMap("C:\\Work\\" + child5.getName(), "file", "5");
        hashMapHandler.addValueToMap(child.getName(), "id", "1");
        hashMapHandler.addValueToMap(child2.getName(), "id", "2");
        hashMapHandler.addValueToMap(child3.getName(), "id", "3");
        hashMapHandler.addValueToMap(child4.getName(), "id", "4");
        hashMapHandler.addValueToMap(child5.getName(), "id", "5");

        return hashMapHandler;
    }

    @Test
    public void when_passed_file_location_objectMapper_can_read_file() throws IOException {
        HashMapHandler hashMapHandler = CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());


        String lel = hashMapHandler.crossLookup("Mark");

        ObjectMapper objectMapper = new ObjectMapper();
        IStorageObject object = objectMapper.readValue(new File(lel), IStorageObject.class);
    }

    @Test
    public void when_hashmaphandler_gets_an_id_and_value_store_them() {

    }

    @Test
    public void when_hashmaphandler_gets_an_id_fetch_value() {

    }

    @Test
    public void when_given_idhashmap_and_filehashmap_and_key_look_up_file_by_value_in_idhashmap() {
//        IdGenerator idGenerator = new IdGenerator();
//        HashMapHandler hashMapHandler = new HashMapHandler();
//        hashMapHandler.addValueToMap("ErikFileLocation","file");
//        hashMapHandler.addValueToMap("Erik","id");
//
//        String lel = hashMapHandler.crossLookup("Erik");
    }
}


class HashMapHandler {
    IdGenerator idGenerator = new IdGenerator();
    HashMap<String, String> fileLocation = new HashMap<>();
    HashMap<String, String> idmap = new HashMap<>();

    public void addValueToMap(String value, String map, String generateFrom) {
        if (map.equals("file")) {
            fileLocation.put(idGenerator.generateId(generateFrom), value);
        }

        if (map.equals("id")) {
            idmap.put(value, idGenerator.generateId(generateFrom));
        }
    }

    public void removeValueToMap(Integer key, String map) {

    }

    public String crossLookup(String key) {
        return fileLocation.get(idmap.get(key));
    }
}

class IdGenerator {
    public String generateId(String valueToGenerateFrom) {
        return valueToGenerateFrom;
    }
}