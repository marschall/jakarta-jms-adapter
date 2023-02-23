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
    jakarta.jms.ConnectionFactory connectionFactory = new JakartaConnectionFactory(broker.createConnectionFactory());
    jmsTemplate = new JmsTemplate(new SingleConnectionFactory(connectionFactory));
  }
  
  @Test
  public void sendAndReceive() {
  }

}
