package filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class HashMapHandler {
    IdGenerator idGenerator = new IdGenerator();
    HashMap<String, String> fileLocation = new HashMap<>();
    HashMap<String, String> childIdMap = new HashMap<>();
    HashMap<String, String> employeeIdMap = new HashMap<>();

    //whenever constructed, the HashMapHandler should check out the saved HashMapHandler
    public HashMapHandler() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            fileLocation = objectMapper.readValue(new File(System.getProperty("user.dir") + "\\File\\HashMaps\\FileLocation"), HashMap.class);
            childIdMap = objectMapper.readValue(new File(System.getProperty("user.dir") + "\\File\\HashMaps\\IDMAP"), HashMap.class);
            employeeIdMap = objectMapper.readValue(new File(System.getProperty("user.dir") + "\\File\\HashMaps\\EmployeeIDMap"), HashMap.class);
        } catch (IOException e) {
            storeHashMapsInFile(objectMapper);
            System.out.println("File Not Found, creating new file");
        }
    }

    public void storeHashMapsInFile(ObjectMapper objectMapper) throws IOException {
        objectMapper.writeValue(new File(System.getProperty("user.dir") + "\\File\\HashMaps\\FileLocation"), fileLocation);
        objectMapper.writeValue(new File(System.getProperty("user.dir") + "\\File\\HashMaps\\IDMAP"), childIdMap);
        objectMapper.writeValue(new File(System.getProperty("user.dir") + "\\File\\HashMaps\\EmployeeIDMap"), employeeIdMap);

    }

    public void addValueToMap(String value, String map, String generateFrom) { // we're never gonna just add it to one map, so why not make the method update both
        if (map.equals("file")) {
            fileLocation.put(idGenerator.generateId(generateFrom), value);
        }

        if (map.equals("id")) {
            childIdMap.put(value, idGenerator.generateId(generateFrom));
        }

        if (map.equals("employeeid")) {
            employeeIdMap.put(value, idGenerator.generateId(generateFrom));
        }
    }

    public void addValuesToMaps(IStorageObject someName, String filePath) {
        addValueToMap(filePath, "file", someName.getIdString());
        switch (someName.getStorageObjectType()) {
            case "Child": {
                addValueToMap(someName.getName(), "id", someName.getIdString());
                break;
            }
            case "Employee": {
                addValueToMap(someName.getName(), "employeeid", someName.getIdString());
                break;
            }
        }
    }

    public void removeValueToMap(Integer key, String map) {

    }

    public Set<String> getKeySetFromhashMap(String mapIdentifier) {
        switch (mapIdentifier) {
            case DataLayerApi.CHILD:
                return childIdMap.keySet();
            case DataLayerApi.EMPLOYEE:
                return employeeIdMap.keySet();
            default:
                return fileLocation.keySet();
        }
    }

    public String crossLookup(String key, String type) {
        switch (type) {
            case DataLayerApi.CHILD:
                return fileLocation.get(childIdMap.get(key));
            case DataLayerApi.EMPLOYEE:
                return fileLocation.get(employeeIdMap.get(key));
            default:
                return null;
        }
    }
}