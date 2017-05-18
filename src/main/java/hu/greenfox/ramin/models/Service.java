package hu.greenfox.ramin.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by HP on 5/18/2017.
 */
public class Service {


  public static String errorReport() {
    return "";
  }

//   @Autowired
//   User user;
  public static void infoRequest(String path, String method, User user) {
    System.out.println("###########################################################");
    System.out.println(LocalDate.now().toString() + " " + LocalTime.now().toString() + " INFO Request "
            + path + " " + method + " " + "username=" + user.getUsername());
  }
}
