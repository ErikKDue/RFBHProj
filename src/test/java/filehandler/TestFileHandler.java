package filehandler;

import businesslayer.Child;
import businesslayer.Parent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TestFileHandler {

    @Test
    public void testSaveIStorageObject() throws ClassNotFoundException {
        CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());
    }

    private HashMapHandler CreateTestChildrenAndAddThemToHashMaps(HashMapHandler hashMapHandler) throws ClassNotFoundException {
        Parent[] parents = new Parent[2];
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
        Child child6 = new Child("Eirikus", "Bruhn", "Iceland", 999, parents);
        fileHandler.WriteToNewFile(child, "Child");
        fileHandler.WriteToNewFile(child2, "Child");
        fileHandler.WriteToNewFile(child3, "Child");
        fileHandler.WriteToNewFile(child4, "Child");
        fileHandler.WriteToNewFile(child5, "Child");
        fileHandler.WriteToNewFile(child6, "Child");
        hashMapHandler.addValueToMap("C:\\Work\\" + child.getName(), "file", child.getName() + child.getLastName());
        hashMapHandler.addValueToMap("C:\\Work\\" + child2.getName(), "file", "2");
        hashMapHandler.addValueToMap("C:\\Work\\" + child3.getName(), "file", "3");
        hashMapHandler.addValueToMap("C:\\Work\\" + child4.getName(), "file", "4");
        hashMapHandler.addValueToMap("C:\\Work\\" + child5.getName(), "file", "5");
        hashMapHandler.addValueToMap(child.getName(), "id", child.getName() + child.getLastName());
        hashMapHandler.addValueToMap(child2.getName(), "id", "2");
        hashMapHandler.addValueToMap(child3.getName(), "id", "3");
        hashMapHandler.addValueToMap(child4.getName(), "id", "4");
        hashMapHandler.addValueToMap(child5.getName(), "id", "5");
        hashMapHandler.addValuesToMaps(child6, fileHandler.calculateFileLocation(child6, child6.getStorageObjectType()));
        return hashMapHandler;
    }

    @Test
    public void when_passed_file_location_objectMapper_can_read_file() throws IOException, ClassNotFoundException {
        HashMapHandler hashMapHandler = CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());

        String lel = hashMapHandler.crossLookup("Mark");

        ObjectMapper objectMapper = new ObjectMapper();
        IStorageObject object = objectMapper.readValue(new File(lel), IStorageObject.class);
    }

    @Test
    public void hashMaps_Saved_After_Use() throws ClassNotFoundException, IOException {
        HashMapHandler hashMapHandler = CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());
        hashMapHandler.storeHashMapsInFile(new ObjectMapper());


    }

    @Test
    public void test_if_HashMapHandler_Loads_HashMaps_Correctly_From_File() {
        HashMapHandler hashMapHandler = new HashMapHandler();

    }

    @Test
    public void when_hashmaphandler_gets_an_id_and_value_store_them() {
        HashMapHandler hashMapHandler = new HashMapHandler();
        hashMapHandler.addValueToMap("Foo", "id", "Bar");
        hashMapHandler.addValueToMap("Foo2", "file", "Bar");
        Assertions.assertEquals(hashMapHandler.crossLookup("Foo"), "Foo2");
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
