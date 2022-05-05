package webapp;

public class UserValidationService {
    public boolean isUserValid(String user, String password) {
        return user.equals("user") && password.equals("password");
    }
}
