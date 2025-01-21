package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("ivan", "petrov", "ivanpetrov@gmail.com", new Car("lexus", 3956));
      User user2 = new User("maria", "kagitina", "mariakagitina@gmail.com", new Car("nissan", 4567));
      User user3 = new User("anna", "koroleva", "annakoroleva@gmail.com", new Car("audi", 9735));
      User user4 = new User("alex", "ivanov", "alexivanov@gmail.com", new Car("opel", 5080));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      System.out.println(userService.getUserByCar("opel", 5080));
      System.out.println((userService.getUserByCar("lexus", 3956)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
