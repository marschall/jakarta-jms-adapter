package com.github.marschall.jakartajmsadapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.TextMessage;

public class JakartaConnectionFactoryTest {

  private static final String QUEUE_NAME = "queue://junit";

  @Rule
  public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

  private JmsOperations jmsTemplate;

  @Before
  public void setUp() {
    jakarta.jms.ConnectionFactory connectionFactory = new JakartaConnectionFactory(this.broker.createConnectionFactory());
    this.jmsTemplate = new JmsTemplate(new SingleConnectionFactory(connectionFactory));
  }

  @Test
  public void sendAndReceive() {
    this.jmsTemplate.send(QUEUE_NAME, session -> session.createTextMessage("hello Jakarta"));
    this.jmsTemplate.receive(QUEUE_NAME);
  }

  @Test
  public void browse() {
    this.jmsTemplate.send(QUEUE_NAME, session -> session.createTextMessage("hello Jakarta"));
    List<String> textMessages = this.jmsTemplate.browse(QUEUE_NAME, (session, browser) -> {
      List<String> messages = new ArrayList<>(1);
      @SuppressWarnings("rawtypes")
      Enumeration enumeration = browser.getEnumeration();
      while (enumeration.hasMoreElements()) {
        Object nextElement = enumeration.nextElement();
        if (nextElement instanceof TextMessage textMessage) {
          messages.add(textMessage.getText());
        }
      }
      return messages;
    });
    assertEquals(List.of("hello Jakarta"), textMessages);
  }

}
