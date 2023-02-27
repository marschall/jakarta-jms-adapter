package com.github.marschall.jakartajmsadapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.config.Configuration;
import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.remoting.impl.invm.InVMConnectorFactory;
import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.JMSContext;

@Disabled
public class ArtemisTest {

  private static final String QUEUE_NAME = "queue://junit";

  private JmsOperations jmsTemplate;

  private EmbeddedActiveMQ server;

  private jakarta.jms.ConnectionFactory jakartaConnectionFactory;

  private ActiveMQConnectionFactory javaxConnectionFactory;

  @Before
  public void setUp() throws Exception {
    Configuration config = new ConfigurationImpl();
    config.addAcceptorConfiguration("in-vm", "vm://0");
    config.setJMXManagementEnabled(false);
    config.setSecurityEnabled(false);

    this.server = new EmbeddedActiveMQ();
    this.server.setConfiguration(config);
    this.server.start();


    TransportConfiguration transportConfiguration = new TransportConfiguration(InVMConnectorFactory.class.getName());

    this.javaxConnectionFactory = ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF, transportConfiguration);

    this.jakartaConnectionFactory = new JakartaConnectionFactory(this.javaxConnectionFactory);
    this.jmsTemplate = new JmsTemplate(new SingleConnectionFactory(this.jakartaConnectionFactory));
  }

  @After
  public void tearDown() throws Exception {
    this.javaxConnectionFactory.close();
    this.server.stop();
  }

  @Test
  public void sendAndReceive() {
    this.jmsTemplate.send(QUEUE_NAME, session -> session.createTextMessage("hello Jakarta"));
    this.jmsTemplate.receive(QUEUE_NAME);
  }

//  @Test
//  public void browse() {
//    this.jmsTemplate.send(QUEUE_NAME, session -> session.createTextMessage("hello Jakarta"));
//    List<String> textMessages = this.jmsTemplate.browse(QUEUE_NAME, (session, browser) -> {
//      List<String> messages = new ArrayList<>(1);
//      @SuppressWarnings("rawtypes")
//      Enumeration enumeration = browser.getEnumeration();
//      while (enumeration.hasMoreElements()) {
//        Object nextElement = enumeration.nextElement();
//        if (nextElement instanceof TextMessage textMessage) {
//          messages.add(textMessage.getText());
//        }
//      }
//      return messages;
//    });
//    assertEquals(List.of("hello Jakarta"), textMessages);
//  }

  @Test
  public void jmsContext() {
    JMSContext jmsContext = this.jakartaConnectionFactory.createContext();
    assertNotNull(jmsContext);
  }

}
