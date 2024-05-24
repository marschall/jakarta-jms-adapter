package com.github.marschall.jakartajmsadapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;

public class JakartaConnectionFactoryTest {

  private static final String QUEUE_NAME = "queue://junit";

  @Rule
  public EmbeddedActiveMQBroker broker;

  public JakartaConnectionFactoryTest() {
    this.broker = new EmbeddedActiveMQBroker();
    this.broker.getBrokerService().setUseJmx(false);
  }

  private JmsOperations jmsTemplate;

  private ConnectionFactory connectionFactory;

  @Before
  public void setUp() {
    connectionFactory = new JakartaConnectionFactory(this.broker.createConnectionFactory());
    this.jmsTemplate = new JmsTemplate(new SingleConnectionFactory(connectionFactory));
  }

  @Test
  public void sendAndReceive() throws JMSException {
    String messageString = "hello Jakarta";
    this.jmsTemplate.send(QUEUE_NAME, session -> session.createTextMessage(messageString));
    Message message = this.jmsTemplate.receive(QUEUE_NAME);
    assertNotNull(message);
    assertEquals(messageString, message.getBody(String.class));
  }

  @Test
  public void convertAndSend() throws JMSException {
    String messageString = "hello Jakarta";
    this.jmsTemplate.convertAndSend(QUEUE_NAME, messageString, message -> {
      assertNull("JMSReplyTo", message.getJMSReplyTo());
      assertNull("JMSDestination", message.getJMSDestination());
      return message;
    });
    Message message = this.jmsTemplate.receive(QUEUE_NAME);
    assertNotNull(message);
    assertEquals(messageString, message.getBody(String.class));
  }

  @Test
  public void browse() {
    String messageString = "hello Jakarta";
    this.jmsTemplate.send(QUEUE_NAME, session -> session.createTextMessage(messageString));
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
    assertEquals(List.of(messageString), textMessages);
  }

  @Test
  public void jmsContext() throws JMSException {
    try (JMSContext jmsContext = this.connectionFactory.createContext()) {
      Queue queue = jmsContext.createQueue(QUEUE_NAME);
      String sent = "hello Jakarta";
      jmsContext.createProducer().send(queue, sent);
      // #receiveBody is not supported
      Message message = jmsContext.createConsumer(queue).receive();
      assertEquals(sent, message.getBody(String.class));
    }
  }

}
