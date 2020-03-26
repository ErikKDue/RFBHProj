package businesslayer;

import filehandler.DataLayerApi;
import filehandler.IStorageObject;

import java.io.IOException;
import java.util.Set;

public class BusinessLayer {
    DataLayerApi dataLayerApi = new DataLayerApi();

    public BusinessLayer() throws IOException {
    }

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
