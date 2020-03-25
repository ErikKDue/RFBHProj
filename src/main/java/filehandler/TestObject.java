package filehandler;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("TestObject")
public class TestObject implements IStorageObject {
    private int testInt;
    private String testString;
    private String testName;

    TestObject() {

    }

    TestObject(int testInt, String testString, String testName) {
        this.testName = testName;
        this.testInt = testInt;
        this.testString = testString;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestInt(int testInt) {
        this.testInt = testInt;
    }

    public int getTestInt() {
        return testInt;
    }

}
