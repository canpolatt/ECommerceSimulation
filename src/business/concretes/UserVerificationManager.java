package business.concretes;

import business.abstracts.UserVerificationService;
import core.utils.RunRules;
import entities.concretes.User;

import java.util.regex.Pattern;

public class UserVerificationManager implements UserVerificationService {
    public static final Pattern mailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    public boolean checkEmail(String email) {
        return mailRegex.matcher(email).find();
    }

    @Override
    public boolean checkFirstName(String firstName) {
        if(firstName.length()>=2){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkLastName(String lastName) {
        if(lastName.length()>=2){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkPassword(String password) {
        if(password.length()>=6){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkPerson(User user) {
        boolean result = RunRules.run(
                checkFirstName(user.getFirstName()),
                checkLastName(user.getLastName()),
                checkPassword(user.getPassword()),
                checkEmail(user.getEmail())
        );
        return result;
    }

    @Override
    public void sendMail(String email) {
        System.out.println("Lütfen "+email+" adresine yollanan doğrulama linkine tıklayın.");
    }

    @Override
    public void verification(User user) {
        user.setUserVerification(true);
        System.out.println(user.getEmail()+" başarıyla doğrulandı artık giriş yapabilirsiniz.");
    }

    @Override
    public boolean checkEmailPassword(String email, String password) {
        if(email != "" &&password!= ""){
            return true;
        }else{
            return false;
        }
    }
}
