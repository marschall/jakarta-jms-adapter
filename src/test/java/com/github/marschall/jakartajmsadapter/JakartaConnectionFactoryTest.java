package com.github.marschall.jakartajmsadapter;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;

public class JakartaConnectionFactoryTest {

  @Rule
  public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

  private JmsOperations jmsTemplate;

  @Before
  public void setUp() {
    jakarta.jms.ConnectionFactory connectionFactory = new JakartaConnectionFactory(this.broker.createConnectionFactory());
    this.jmsTemplate = new JmsTemplate(new SingleConnectionFactory(connectionFactory));
//    JakartaDestination.fromJavax(broker.getDestination("queue://junit"));
  }

  @Test
  public void sendAndReceive() {
    this.jmsTemplate.send("queue://junit", session -> session.createTextMessage("hello Jakarta"));
    this.jmsTemplate.receive("queue://junit");
  }

}
