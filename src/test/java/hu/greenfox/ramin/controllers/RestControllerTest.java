package hu.greenfox.ramin.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import hu.greenfox.ramin.ChatappApplication;
import hu.greenfox.ramin.models.Client;
import hu.greenfox.ramin.models.Message;
import hu.greenfox.ramin.models.MessageCenter;
import java.sql.Timestamp;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChatappApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class RestControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void receivingErrorTest() throws Exception {
    ///////////////////////////////////6 making Object of our models //////////
    MessageCenter messageCenter = new MessageCenter();
    Message message = new Message("Ramin", "Hello!");
    Client client = new Client("Ramin");
    messageCenter.setMessage(message);
    messageCenter.setClient(client);
    ////////// Using Object Mapper to change JASON object to String, because we need it for .content in mocMvc ///////
    ObjectMapper objectMapper = new ObjectMapper();
    String stringObject = objectMapper.writeValueAsString(messageCenter);
    ///////////////////////////////////////////////////////////////////////////////6
    mockMvc.perform(post("/api/message/receive")
        .contentType(MediaType.APPLICATION_JSON)
        .content(stringObject))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.status", is("error")))
        .andExpect(jsonPath("$.message", is("Missing field(s): message.timestamp, client.id")))
        .andDo(print());
  }


}
