package hu.greenfox.ramin.models;

/**
 * Created by HP on 5/21/2017.
 */
public class MessageCenter {

  public Message message;
  public Client client;

  public MessageCenter(){
    this.message = new Message();
    this.client = new Client();
  }

  public MessageCenter(Message message, Client client) {
    this.message = message;
    this.client = client;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "MessageCenter{" +
            "message=" + message +
            ", client=" + client +
            '}';
  }
}
