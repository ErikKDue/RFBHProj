package filehandler;

import businesslayer.Child;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class FileHandler {
    ObjectMapper objectMapper = new ObjectMapper();

    public Optional<String> WriteToNewFile(IStorageObject contents, String type) {
        try {
            File newFile = new File(calculateFileLocation(contents, type));
            if (newFile.createNewFile()) {
                objectMapper.writeValue(newFile, contents);
                return Optional.of(expectedReturnValue(contents, type));
            } else {
                return Optional.of("File already exists, could not create");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.of("Failed to create file");
    }

    public String calculateFileLocation(IStorageObject dataType, String type) throws ClassNotFoundException {
        switch (type) {
            case "TestObject":
                TestObject testObject = (TestObject) dataType;
                return "C:\\Work\\" + testObject.getTestName();

            case "Child": {
                Child child = (Child) dataType;
                return "C:\\Work\\" + child.getName();
            }
            default: {
                throw new ClassNotFoundException("Datatype could not be matched");

            }
        }
    }

    public String expectedReturnValue(IStorageObject dataType, String type) throws ClassNotFoundException {
        String fileLocation = calculateFileLocation(dataType, type);
        UUID uuid = UUID.randomUUID();

        return uuid + "--" + fileLocation;
    }

    public IStorageObject readFile(String identifier) throws JsonProcessingException {
        return objectMapper.readValue(findFileLocation(identifier), IStorageObject.class);
    }

    //Check HashMaps!
    public String findFileLocation(String identifier) {
        return "FileLocation";
    }

}
