package business.concretes;

import business.abstracts.MailService;
import business.abstracts.UserService;
import business.abstracts.UserVerificationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;
    private UserVerificationService userVerificationService;
    private MailService mailService;


    public UserManager(UserDao userDao,UserVerificationService userVerificationService,MailService mailService){
        this.userDao=userDao;
        this.userVerificationService=userVerificationService;
        this.mailService=mailService;
    }

    @Override
    public void add(User user) {
        if(!checkIfUserExists(user.getEmail())){
            System.out.println("Bu mail adresi daha önce kullanılmış");
            return;
        }
        if(!mailService.checkGoogleMail(user)){
            System.out.println("Mail adresiniz google tarafından doğrulanamadı.");
            return;
        }
        if(!userVerificationService.checkPerson(user)){
            System.out.println("Ad ve soyad kısmı 2 karakterden fazla, parolanız ise 6 karakterden fazla olmalıdır.");
            return;
        }
        this.userDao.save(user);
        userVerificationService.sendMail(user.getEmail());
    }

    @Override
    public void update(User user) {
        //Kontroller yapılmadı
        this.userDao.update(user);
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public void login(String email, String password) {
        if(!userVerificationService.checkEmailPassword(email,password)){
            System.out.println("Giriş başarısız! Email ve şifre alanı boş olamaz!!");
            return;
        }
        User loginUser=userDao.checkEmailPassword(email,password);
        if(loginUser!=null && loginUser.isUserVerification()){
            System.out.println(loginUser.getFirstName()+" "+loginUser.getLastName()+" kullancısı için giriş başarılı.");
        }else{
            System.out.println("Hatalı giriş veya doğrulanmamış mail adresi.");
        }
    }

    private boolean checkIfUserExists(String email) {
        return userDao.get(email) == null;
    }
}
