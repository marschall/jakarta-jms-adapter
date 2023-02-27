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
    JavaxExceptionListener javaxListener = listener != null ? new JavaxExceptionListener(listener) : null;
    try {
      this.javaxJMSContext.setExceptionListener(javaxListener);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    this.listener = listener;
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
    try {
      this.javaxJMSContext.close();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public BytesMessage createBytesMessage() {
    try {
      return new JakartaBytesMessage(this.javaxJMSContext.createBytesMessage());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MapMessage createMapMessage() {
    try {
      return new JakartaMapMessage(this.javaxJMSContext.createMapMessage());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message createMessage() {
    try {
      return new JakartaMessage(this.javaxJMSContext.createMessage());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ObjectMessage createObjectMessage() {
    try {
      return new JakartaObjectMessage(this.javaxJMSContext.createObjectMessage());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ObjectMessage createObjectMessage(Serializable object) {
    try {
      return new JakartaObjectMessage(this.javaxJMSContext.createObjectMessage(object));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public StreamMessage createStreamMessage() {
    try {
      return new JakartaStreamMessage(this.javaxJMSContext.createStreamMessage());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TextMessage createTextMessage() {
    try {
      return new JakartaTextMessage(this.javaxJMSContext.createTextMessage());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TextMessage createTextMessage(String text) {
    try {
      return new JakartaTextMessage(this.javaxJMSContext.createTextMessage(text));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
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
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createConsumer(javaxDestination));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createConsumer(Destination destination, String messageSelector) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createConsumer(javaxDestination, messageSelector));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createConsumer(javaxDestination, messageSelector, noLocal));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Queue createQueue(String queueName) {
    try {
      return new JakartaQueue(this.javaxJMSContext.createQueue(queueName));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Topic createTopic(String topicName) {
    try {
      return new JakartaTopic(this.javaxJMSContext.createTopic(topicName));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createDurableConsumer(Topic topic, String name) {
    javax.jms.Topic javaxTopic = Wrapper.unwrapUnchecked(topic, javax.jms.Topic.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createDurableConsumer(javaxTopic, name));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createDurableConsumer(Topic topic, String name, String messageSelector, boolean noLocal) {
    javax.jms.Topic javaxTopic = Wrapper.unwrapUnchecked(topic, javax.jms.Topic.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createDurableConsumer(javaxTopic, name, messageSelector, noLocal));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createSharedDurableConsumer(Topic topic, String name) {
    javax.jms.Topic javaxTopic = Wrapper.unwrapUnchecked(topic, javax.jms.Topic.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createSharedDurableConsumer(javaxTopic, name));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createSharedDurableConsumer(Topic topic, String name, String messageSelector) {
    javax.jms.Topic javaxTopic = Wrapper.unwrapUnchecked(topic, javax.jms.Topic.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createSharedDurableConsumer(javaxTopic, name, messageSelector));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName) {
    javax.jms.Topic javaxTopic = Wrapper.unwrapUnchecked(topic, javax.jms.Topic.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createSharedConsumer(javaxTopic, sharedSubscriptionName));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName, String messageSelector) {
    javax.jms.Topic javaxTopic = Wrapper.unwrapUnchecked(topic, javax.jms.Topic.class);
    try {
      return new JakartaJMSConsumer(this.javaxJMSContext.createSharedConsumer(javaxTopic, sharedSubscriptionName, messageSelector));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueBrowser createBrowser(Queue queue) {
    javax.jms.Queue javaxQueue = Wrapper.unwrapUnchecked(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueBrowser(this.javaxJMSContext.createBrowser(javaxQueue));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueBrowser createBrowser(Queue queue, String messageSelector) {
    javax.jms.Queue javaxQueue = Wrapper.unwrapUnchecked(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueBrowser(this.javaxJMSContext.createBrowser(javaxQueue, messageSelector));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TemporaryQueue createTemporaryQueue() {
    try {
      return new JakartaTemporaryQueue(this.javaxJMSContext.createTemporaryQueue());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TemporaryTopic createTemporaryTopic() {
    try {
      return new JakartaTemporaryTopic(this.javaxJMSContext.createTemporaryTopic());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
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
