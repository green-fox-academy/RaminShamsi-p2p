package hu.greenfox.ramin.repository;


import hu.greenfox.ramin.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessageRepo extends CrudRepository<Message, Long> {
}
