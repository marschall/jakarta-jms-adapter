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

  JakartaJMSContext(javax.jms.JMSContext javaxJMSContext) {
    this.javaxJMSContext = javaxJMSContext;
  }

  @Override
  public JMSContext createContext(int sessionMode) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer createProducer() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getClientID() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setClientID(String clientID) {
    // TODO Auto-generated method stub

  }

  @Override
  public ConnectionMetaData getMetaData() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ExceptionListener getExceptionListener() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setExceptionListener(ExceptionListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void start() {
    // TODO Auto-generated method stub

  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setAutoStart(boolean autoStart) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean getAutoStart() {
    // TODO Auto-generated method stub
    return false;
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
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getSessionMode() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void commit() {
    // TODO Auto-generated method stub

  }

  @Override
  public void rollback() {
    // TODO Auto-generated method stub

  }

  @Override
  public void recover() {
    // TODO Auto-generated method stub

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
    // TODO Auto-generated method stub

  }

  @Override
  public void acknowledge() {
    // TODO Auto-generated method stub

  }

}
