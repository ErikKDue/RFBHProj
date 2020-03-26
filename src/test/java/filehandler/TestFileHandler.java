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
        FileHandler fileHandler = new FileHandler(new ObjectMapper());
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
        hashMapHandler.addValueToMap(System.getProperty("user.dir") + "\\File\\" + child.getName(), "file", child.getName() + child.getLastName());
        hashMapHandler.addValueToMap(System.getProperty("user.dir") + "\\File\\" + child2.getName(), "file", "2");
        hashMapHandler.addValueToMap(System.getProperty("user.dir") + "\\File\\" + child3.getName(), "file", "3");
        hashMapHandler.addValueToMap(System.getProperty("user.dir") + "\\File\\" + child4.getName(), "file", "4");
        hashMapHandler.addValueToMap(System.getProperty("user.dir") + "\\File\\" + child5.getName(), "file", "5");
        hashMapHandler.addValueToMap(child.getName(), "id", child.getName() + child.getLastName());
        hashMapHandler.addValueToMap(child2.getName(), "id", "2");
        hashMapHandler.addValueToMap(child3.getName(), "id", "3");
        hashMapHandler.addValueToMap(child4.getName(), "id", "4");
        hashMapHandler.addValueToMap(child5.getName(), "id", "5");
        hashMapHandler.addValuesToMaps(child6, fileHandler.calculateFileLocation(child6, child6.getStorageObjectType()));
        hashMapHandler.getKeySetFromhashMap("Mref");
        return hashMapHandler;
    }

    @Test
    public void when_passed_file_location_objectMapper_can_read_file() throws IOException, ClassNotFoundException {
        HashMapHandler hashMapHandler = CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());

        String lel = hashMapHandler.crossLookup("Mark");

        ObjectMapper objectMapper = new ObjectMapper();
        Child object = (Child) objectMapper.readValue(new File(lel), IStorageObject.class);
        Assertions.assertEquals("Mark", object.getName());
        Assertions.assertEquals("Mellemved", object.getAddress());
    }

    @Test
    public void hashMaps_Saved_After_Use() throws ClassNotFoundException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMapHandler hashMapHandler = CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());
        hashMapHandler.storeHashMapsInFile(objectMapper);

        HashMapHandler retrievedHashMapHandler = new HashMapHandler();
        Assertions.assertEquals(retrievedHashMapHandler.crossLookup("Mark"), hashMapHandler.crossLookup("Mark"));
        Assertions.assertEquals(retrievedHashMapHandler.crossLookup("Eirikus"), hashMapHandler.crossLookup("Eirikus"));
        Assertions.assertEquals(retrievedHashMapHandler.crossLookup("Alice"), hashMapHandler.crossLookup("Alice"));
        Assertions.assertNotEquals(retrievedHashMapHandler.crossLookup("Alice"), hashMapHandler.crossLookup("Test"));


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
        HashMapHandler hashMapHandler = new HashMapHandler();

        Assertions.assertEquals(System.getProperty("user.dir") + "\\File\\Eirikus", hashMapHandler.crossLookup("Eirikus"));
    }


    ///(System.getProperty("user.dir")+"\\Files
    @Test
    public void relativePathTest() {
        System.out.println(System.getProperty("user.dir"));
    }
}
