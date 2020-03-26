package businesslayer;

import filehandler.DataLayerApi;
import filehandler.IStorageObject;

import java.io.IOException;
import java.util.Set;

public class BusinessLayer {
    DataLayerApi dataLayerApi = new DataLayerApi();
    AccountVerifier accountVerifier = new AccountVerifier();

    public boolean logIn(String userNameInput, String passwordInput) {
        return accountVerifier.verify(userNameInput, passwordInput, dataLayerApi.retrieveHashedPassword(userNameInput, DataLayerApi.EMPLOYEE));
    }

    public BusinessLayer() throws IOException {
    }

    public Set<String> displayChildren() {
        return dataLayerApi.getListOfIStorageObjectIds(DataLayerApi.CHILD);
    }

    public void saveIStorageObject(IStorageObject object) {
        dataLayerApi.addIStorageObject(object);
    }

    public IStorageObject fetchIStorageObject(String identifier, String type) {
        return dataLayerApi.retrieveIStorageObject(identifier, type);
    }
}
