package core;

import business.abstracts.MailService;
import entities.concretes.User;
import googleMailAPI.GoogleMailApi;

public class GoogleMailApiAdapter implements MailService {
    @Override
    public boolean checkGoogleMail(User user) {
        GoogleMailApi googleMailApi=new GoogleMailApi();
        return googleMailApi.checkGoogleMail(user);
    }
}
