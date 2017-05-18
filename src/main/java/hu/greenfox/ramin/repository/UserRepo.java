package hu.greenfox.ramin.repository;

import hu.greenfox.ramin.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserRepo extends CrudRepository<User, Long> {
  // SELECT * FROM User WHERE username = name;
  List<User> findByUsername(String name);
}
