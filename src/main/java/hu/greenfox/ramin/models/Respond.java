package hu.greenfox.ramin.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.*;
import org.springframework.stereotype.Component;


@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OkRespond.class, name = "ok"),
        @JsonSubTypes.Type(value = ErrorRespond.class, name = "error")})
@Component
public class Respond {


  public Respond(){

  }


}
