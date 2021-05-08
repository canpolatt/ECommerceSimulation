import business.abstracts.UserService;
import business.abstracts.UserVerificationService;
import business.concretes.UserManager;
import business.concretes.UserVerificationManager;
import core.GoogleMailApiAdapter;
import dataAccess.concretes.UserMemoryDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
	// write your code here
        UserService userService=new UserManager(new UserMemoryDao(),new UserVerificationManager(),new GoogleMailApiAdapter());
        UserVerificationService userVerificationService=new UserVerificationManager();
        User user1=new User(1,"Can","Polat","can@gmail.com","123456789");
        User user2=new User(2,"Ali","Polat","can@gmail.com","123456789");
        User user3=new User(3,"Can","Polat","example@gmail.com","123");
        User user4=new User(4,"Can","Polat","example@example.com","123456789");
        System.out.println("--------Veri tabanı--------");
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        System.out.println("--------Hesap Doğrulama--------");
        userVerificationService.verification(user1);
        System.out.println("--------Giriş Yapma--------");
        userService.login("can@gmail.com","123456789");
        userService.login("aaa","1312");



    }
}
