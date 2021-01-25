package filehandler;

import businesslayer.Child;
import businesslayer.Employee;
import businesslayer.Parent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestFileHandler {

    @Test
    public void testSaveIStorageObject() throws ClassNotFoundException, IOException {
        CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());
    }

    private HashMapHandler CreateTestChildrenAndAddThemToHashMaps(HashMapHandler hashMapHandler) throws ClassNotFoundException {
        Parent[] parents = new Parent[2];
        FileHandler fileHandler = new FileHandler(new ObjectMapper());
        Child child = new Child("Test", "Child", "bar", 17, parents);
        Child child2 = new Child("Tester", "Child2", "Rumlebef", 12, parents);

        Child child3 = new Child("Mark", "Markusson", "Mellemved", 11, parents);

        Child child4 = new Child("Alex", "Torsson", "Mellemved", 9, parents);

        Child child5 = new Child("Alice", "Alisson", "Oslo", 7, parents);

        Child child6 = new Child("Eirikus", "Bruhn", "Iceland", 999, parents);
        fileHandler.WriteToNewFile(child, "Child");
        fileHandler.WriteToNewFile(child2, "Child");
        fileHandler.WriteToNewFile(child3, "Child");
        fileHandler.WriteToNewFile(child4, "Child");
        fileHandler.WriteToNewFile(child5, "Child");
        fileHandler.WriteToNewFile(child6, "Child");
        hashMapHandler.addValueToMap(".\\File\\" + child.getName(), "file", child.getName() + child.getLastName());
        hashMapHandler.addValueToMap(".\\File\\" + child2.getName(), "file", "2");
        hashMapHandler.addValueToMap(".\\File\\" + child3.getName(), "file", "3");
        hashMapHandler.addValueToMap(".\\File\\" + child4.getName(), "file", "4");
        hashMapHandler.addValueToMap(".\\File\\" + child5.getName(), "file", "5");
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
    public void you_can_make_an_employee_and_save_it() throws ClassNotFoundException, IOException {
        HashMapHandler hashMapHandler = new HashMapHandler();
        hashMapHandler.storeHashMapsInFile(new ObjectMapper());
        FileHandler fileHandler = new FileHandler(new ObjectMapper());
        Employee employee = new Employee("Dolph", "Madsen", "Kronevej 1300", false, new ArrayList<String>(), "1234");
        fileHandler.WriteToNewFile(employee, "Employee");
        hashMapHandler.addValuesToMaps(employee, fileHandler.calculateFileLocation(employee, employee.getStorageObjectType()));
        System.out.println(hashMapHandler.getKeySetFromhashMap(DataLayerApi.EMPLOYEE));
        hashMapHandler.storeHashMapsInFile(new ObjectMapper());

    }

    @Test
    public void testFile() throws IOException {
        File file = new File(".\\File\\EmployeeJohn");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(file, Employee.class).getHashedPassword());
    }

    @Test
    public void when_passed_file_location_objectMapper_can_read_file() throws IOException, ClassNotFoundException {
        HashMapHandler hashMapHandler = CreateTestChildrenAndAddThemToHashMaps(new HashMapHandler());

        String lel = hashMapHandler.crossLookup("Mark", DataLayerApi.CHILD);

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
        Assertions.assertEquals(retrievedHashMapHandler.crossLookup("Mark", DataLayerApi.CHILD), hashMapHandler.crossLookup("Mark", DataLayerApi.CHILD));
        Assertions.assertEquals(retrievedHashMapHandler.crossLookup("Eirikus", DataLayerApi.CHILD), hashMapHandler.crossLookup("Eirikus", DataLayerApi.CHILD));
        Assertions.assertEquals(retrievedHashMapHandler.crossLookup("Alice", DataLayerApi.CHILD), hashMapHandler.crossLookup("Alice", DataLayerApi.CHILD));
        Assertions.assertNotEquals(retrievedHashMapHandler.crossLookup("Alice", DataLayerApi.CHILD), hashMapHandler.crossLookup("Test", DataLayerApi.CHILD));


    }

    @Test
    public void when_hashmaphandler_gets_an_id_and_value_store_them() throws IOException {
        HashMapHandler hashMapHandler = new HashMapHandler();
        hashMapHandler.addValueToMap("Foo", "id", "Bar");
        hashMapHandler.addValueToMap("Foo2", "file", "Bar");
        Assertions.assertEquals(hashMapHandler.crossLookup("Foo", DataLayerApi.CHILD), "Foo2");
    }


    @Test
    public void when_given_idhashmap_and_filehashmap_and_key_look_up_file_by_value_in_idhashmap() throws IOException {
        HashMapHandler hashMapHandler = new HashMapHandler();

        Assertions.assertEquals(".\\File\\Eirikus", hashMapHandler.crossLookup("Eirikus", DataLayerApi.CHILD));
    }


    ///(".\\Files
    @Test
    public void relativePathTest() {
        System.out.println(".\\File\\");
    }
}
