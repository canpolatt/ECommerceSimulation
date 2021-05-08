package googleMailAPI;

import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleMailApi {
    public boolean checkGoogleMail(User user){
        Pattern pattern=Pattern.compile("@gmail.com",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(user.getEmail());
        return matcher.find();
    }
}
