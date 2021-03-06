package hu.greenfox.ramin.repository;


import hu.greenfox.ramin.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface MessageRepo extends CrudRepository<Message, Long> {
  List<Message> findAllByOrderByTimestampDesc();
}
