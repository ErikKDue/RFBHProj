package businesslayer;

import filehandler.DataLayerApi;
import filehandler.IStorageObject;

import java.util.Set;

public class BusinessLayer {
    DataLayerApi dataLayerApi = new DataLayerApi();

    public Set<String> displayChildren() {
        return dataLayerApi.getListOfIStorageObjectIds(DataLayerApi.CHILD);
    }

    public void saveIStorageObject(IStorageObject object) {
        dataLayerApi.addIStorageObject(object);
    }

    public IStorageObject fetchIStorageObject(String identifier) {
        return dataLayerApi.retrieveIStorageObject(identifier);
    }
}
