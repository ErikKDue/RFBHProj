package filehandler;

import businesslayer.Child;
import businesslayer.Employee;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TestObject.class, name = "TestObject"),
        @JsonSubTypes.Type(value = Child.class, name = "Child"),
        @JsonSubTypes.Type(value = Employee.class, name = "Employee")
})
public interface IStorageObject {

    public String getIdString();

    public String getName();

    public String getStorageObjectType();
}
