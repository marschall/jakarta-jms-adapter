package com.github.marschall.jakartajmsadapter;

import java.io.Serializable;

import jakarta.jms.BytesMessage;
import jakarta.jms.ConnectionMetaData;
import jakarta.jms.Destination;
import jakarta.jms.ExceptionListener;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;
import jakarta.jms.QueueBrowser;
import jakarta.jms.StreamMessage;
import jakarta.jms.TemporaryQueue;
import jakarta.jms.TemporaryTopic;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;

final class JakartaJMSContext implements JMSContext {

  private final javax.jms.JMSContext javaxJMSContext;
  private ExceptionListener listener;

  JakartaJMSContext(javax.jms.JMSContext javaxJMSContext) {
    this.javaxJMSContext = javaxJMSContext;
  }

  @Override
  public JMSContext createContext(int sessionMode) {
    try {
      return new JakartaJMSContext(this.javaxJMSContext.createContext(sessionMode));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer createProducer() {
    try {
      return new JakartaJMSProducer(this.javaxJMSContext.createProducer());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getClientID() {
    try {
      return this.javaxJMSContext.getClientID();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setClientID(String clientID) {
    try {
      this.javaxJMSContext.setClientID(clientID);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionMetaData getMetaData() {
    try {
      return new JakartaConnectionMetaData(this.javaxJMSContext.getMetaData());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ExceptionListener getExceptionListener() {
    try {
      this.javaxJMSContext.getExceptionListener();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this.listener;
  }

  @Override
  public void setExceptionListener(ExceptionListener listener) {
    this.listener = listener;
    JavaxExceptionListener javaxListener = listener != null ? new JavaxExceptionListener(listener) : null;
    try {
      this.javaxJMSContext.setExceptionListener(javaxListener);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void start() {
    try {
      this.javaxJMSContext.start();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void stop() {
    try {
      this.javaxJMSContext.stop();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }

  }

  @Override
  public void setAutoStart(boolean autoStart) {
    try {
      this.javaxJMSContext.setAutoStart(autoStart);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getAutoStart() {
    try {
      return this.javaxJMSContext.getAutoStart();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }

  @Override
  public BytesMessage createBytesMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MapMessage createMapMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Message createMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ObjectMessage createObjectMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ObjectMessage createObjectMessage(Serializable object) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public StreamMessage createStreamMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TextMessage createTextMessage() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TextMessage createTextMessage(String text) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean getTransacted() {
    try {
      return this.javaxJMSContext.getTransacted();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getSessionMode() {
    try {
      return this.javaxJMSContext.getSessionMode();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void commit() {
    try {
      this.javaxJMSContext.commit();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void rollback() {
    try {
      this.javaxJMSContext.rollback();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void recover() {
    try {
      this.javaxJMSContext.recover();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createConsumer(Destination destination) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createConsumer(Destination destination,
          String messageSelector) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createConsumer(Destination destination,
          String messageSelector, boolean noLocal) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Queue createQueue(String queueName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Topic createTopic(String topicName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createDurableConsumer(Topic topic, String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createDurableConsumer(Topic topic, String name,
          String messageSelector, boolean noLocal) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createSharedDurableConsumer(Topic topic, String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createSharedDurableConsumer(Topic topic, String name,
          String messageSelector) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createSharedConsumer(Topic topic,
          String sharedSubscriptionName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSConsumer createSharedConsumer(Topic topic,
          String sharedSubscriptionName, String messageSelector) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public QueueBrowser createBrowser(Queue queue) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public QueueBrowser createBrowser(Queue queue, String messageSelector) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TemporaryQueue createTemporaryQueue() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TemporaryTopic createTemporaryTopic() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void unsubscribe(String name) {
    try {
      this.javaxJMSContext.unsubscribe(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void acknowledge() {
    try {
      this.javaxJMSContext.acknowledge();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

}
