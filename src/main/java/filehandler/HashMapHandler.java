package filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class HashMapHandler {
    IdGenerator idGenerator = new IdGenerator();
    HashMap<String, String> fileLocation = new HashMap<>();
    HashMap<String, String> idmap = new HashMap<>();

    //whenever constructed, the HashMapHandler should check out the saved HashMapHandler
    public HashMapHandler() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            fileLocation = objectMapper.readValue(new File("C:\\Work\\HashMaps\\FileLocation"), HashMap.class);
            idmap = objectMapper.readValue(new File("C:\\Work\\HashMaps\\IDMAP"), HashMap.class);
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    public void storeHashMapsInFile(ObjectMapper objectMapper) throws IOException {
        objectMapper.writeValue(new File("C:\\Work\\HashMaps\\FileLocation"), fileLocation);
        objectMapper.writeValue(new File("C:\\Work\\HashMaps\\IDMAP"), idmap);

    }

    public void addValueToMap(String value, String map, String generateFrom) { // we're never gonna just add it to one map, so why not make the method update both
        if (map.equals("file")) {
            fileLocation.put(idGenerator.generateId(generateFrom), value);
        }

        if (map.equals("id")) {
            idmap.put(value, idGenerator.generateId(generateFrom));
        }
    }

    public void addValuesToMaps(IStorageObject someName, String filePath) {
        addValueToMap(filePath, "file", someName.getIdString());

        addValueToMap(someName.getName(), "id", someName.getIdString());

    }

    public void removeValueToMap(Integer key, String map) {

    }

    public String crossLookup(String key) {
        return fileLocation.get(idmap.get(key));
    }
}