package filehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class FileHandler {
    ObjectMapper objectMapper = new ObjectMapper();

    public Optional<String> WriteToNewFile(IStorageObject contents){
        try{
            File newFile = new File(calculateFileLocation(contents));
            if(newFile.createNewFile()){
                objectMapper.writeValue(newFile, contents);
                return Optional.of(expectedReturnValue(contents));
            } else {
                return Optional.of("File already exists, could not create");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.of("Failed to create file");
    }

    public String calculateFileLocation(IStorageObject dataType) throws ClassNotFoundException {
        String type = dataType.getType();
        switch (type) {
            case "TestObject" :
                TestObject testObject = (TestObject) dataType;
                return "C:\\Work\\" + testObject.getTestName();

            /*case "Student" : {
                Student student = (Student) dataType;
                return "C:\\Work\\Exam\\Students\\" + student.getName();
            }
            case "Teacher" : {
                Teacher teacher = (Teacher) dataType;
                return "C:\\Work\\Exam\\Teachers\\" + teacher.getName();
            }*/



            default:{
                throw new ClassNotFoundException("Datatype could not be matched");

            }
        }
    }

    public String expectedReturnValue(IStorageObject dataType) throws ClassNotFoundException {
        String fileLocation = calculateFileLocation(dataType);
        UUID uuid = UUID.randomUUID();

        return uuid + "--" + fileLocation;
    }

    public IStorageObject readFile(String identifier) throws JsonProcessingException, ClassNotFoundException {
        IStorageObject file = objectMapper.readValue(findFileLocation(identifier), IStorageObject.class);
        String type = file.getType();
        switch (type) {
            case "TestObject" :
                return (TestObject) file;

            default:{
                throw new ClassNotFoundException("Datatype could not be matched");

            }
        }

    }

    public String findFileLocation(String identifier){
        return "FileLocation";
    }

}
