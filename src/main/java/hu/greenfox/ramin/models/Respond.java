package hu.greenfox.ramin.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import static javax.swing.Action.NAME;
import static javax.xml.bind.annotation.XmlAccessType.PROPERTY;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "status")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OkRespond.class, name = "ok"),
        @JsonSubTypes.Type(value = ErrorRespond.class, name = "error")})
@Component
public class Respond {


  public Respond(){

  }


}
