package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> getAllUsers();
   public List<Car> getAllCars();
   public User getUserByCar(String model, int series);
}
