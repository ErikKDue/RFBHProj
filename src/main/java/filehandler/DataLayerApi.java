package filehandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;
import java.util.Set;


public class DataLayerApi {
    public static final String CHILD = "Child";
    public static final String EMPLOYEE = "Employee";
    ObjectMapper objectMapper = new ObjectMapper();

    FileHandler fileHandler = new FileHandler(objectMapper);
    HashMapHandler hashMapHandler = new HashMapHandler();

    public Set<String> getListOfIStorageObjectIds(String identifier) {
        return hashMapHandler.getKeySetFromhashMap(identifier);
    }

    public void addIStorageObject(IStorageObject object) {
        try {
            fileHandler.WriteToNewFile(object, object.getStorageObjectType());
            hashMapHandler.addValuesToMaps(object, fileHandler.calculateFileLocation(object, object.getStorageObjectType()));
            hashMapHandler.storeHashMapsInFile(objectMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public IStorageObject retrieveIStorageObject(String identifier) {
        Optional<IStorageObject> iStorageObjectOptional = fileHandler.readFile(hashMapHandler.crossLookup(identifier));
        return iStorageObjectOptional.orElse(null);
    }

}