package businesslayer;

public class AccountVerifier {
    public boolean verify(String userNameInput, String passwordInput, int hashedPassword) {
        if ((userNameInput + passwordInput).hashCode() == hashedPassword) {
            return true;
        } else {
            return false;
        }
    }

}
