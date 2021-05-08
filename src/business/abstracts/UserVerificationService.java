package business.abstracts;

import entities.concretes.User;

public interface UserVerificationService {
    boolean checkEmail(String email);
    boolean checkFirstName(String firstName);
    boolean checkLastName(String lastName);
    boolean checkPassword(String password);
    boolean checkPerson(User user);
    void sendMail(String email);
    void verification(User user);
    boolean checkEmailPassword(String email, String password);

}
