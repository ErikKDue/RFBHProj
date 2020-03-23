package filehandler;

import org.junit.jupiter.api.Test;

//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

public class TestFileHandler {

    @Test
    public void test_this() {
        System.out.println("HEllo This");
    }

    //bøøh

    @Test
    public void testFileCreate() {
        //make object
        TestObject testObject = new TestObject(9, "foo", "bar");
        // try and save it
        FileHandler fileHandler = new FileHandler();
        fileHandler.WriteToNewFile(testObject);
    }
}