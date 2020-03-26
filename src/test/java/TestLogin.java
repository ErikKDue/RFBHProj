import businesslayer.AccountVerifier;
import businesslayer.BusinessLayer;
import businesslayer.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class TestLogin {
    @Test
    public void cannot_login_with_wrong_password() throws IOException {
        BusinessLayer businessLayer = new BusinessLayer();
        Employee employee = new Employee("Dolph", "Madsen", "Kronevej 1300", false, new ArrayList<String>(), "Doed ved koelle!");
        businessLayer.saveIStorageObject(employee);
        AccountVerifier accountVerifier = new AccountVerifier();
        Assertions.assertFalse(accountVerifier.verify(employee.getName(), "Blibla", employee.getHashedPassword()));

    }

    @Test
    public void can_login_with_right_password() throws IOException {
        BusinessLayer businessLayer = new BusinessLayer();
        Employee employee = new Employee("Dolph", "Madsen", "Kronevej 1300", false, new ArrayList<String>(), "Doed ved koelle!");
        businessLayer.saveIStorageObject(employee);
        AccountVerifier accountVerifier = new AccountVerifier();
        Assertions.assertTrue(accountVerifier.verify(employee.getName(), "Doed ved koelle!", employee.getHashedPassword()));
    }

    @Test
    public void saved_password_matches_expected() throws IOException {
        BusinessLayer businessLayer = new BusinessLayer();
        Employee employee = new Employee("Dolph", "Madsen", "Kronevej 1300", false, new ArrayList<String>(), "Doed ved koelle!");
        businessLayer.saveIStorageObject(employee);
        businessLayer.fetchIStorageObject(employee.getName(), employee.getStorageObjectType());
    }

}
