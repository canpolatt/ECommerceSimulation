package business.abstracts;

import entities.concretes.User;

public interface MailService {
    boolean checkGoogleMail(User user);
}
