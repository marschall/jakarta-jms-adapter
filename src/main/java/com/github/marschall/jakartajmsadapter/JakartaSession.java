package com.github.marschall.jakartajmsadapter;

import java.io.Serializable;

import jakarta.jms.BytesMessage;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;
import jakarta.jms.MessageProducer;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;
import jakarta.jms.QueueBrowser;
import jakarta.jms.Session;
import jakarta.jms.StreamMessage;
import jakarta.jms.TemporaryQueue;
import jakarta.jms.TemporaryTopic;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;
import jakarta.jms.TopicSubscriber;

final class JakartaSession implements Session {

  private final javax.jms.Session javaxSession;
  private MessageListener listener;

  JakartaSession(javax.jms.Session javaxSession) {
    this.javaxSession = javaxSession;
  }

  @Override
  public BytesMessage createBytesMessage() throws JMSException {
    try {
      return new JakartaBytesMessage(this.javaxSession.createBytesMessage());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MapMessage createMapMessage() throws JMSException {
    try {
      return new JakartaMapMessage(this.javaxSession.createMapMessage());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message createMessage() throws JMSException {
    try {
      return new JakartaMessage(this.javaxSession.createMessage());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ObjectMessage createObjectMessage() throws JMSException {
    try {
      return new JakartaObjectMessage(this.javaxSession.createObjectMessage());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ObjectMessage createObjectMessage(Serializable object) throws JMSException {
    try {
      return new JakartaObjectMessage(this.javaxSession.createObjectMessage(object));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public StreamMessage createStreamMessage() throws JMSException {
    try {
      return new JakartaStreamMessage(this.javaxSession.createStreamMessage());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TextMessage createTextMessage() throws JMSException {
    try {
      return new JakartaTextMessage(this.javaxSession.createTextMessage());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TextMessage createTextMessage(String text) throws JMSException {
    try {
      return new JakartaTextMessage(this.javaxSession.createTextMessage(text));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getTransacted() throws JMSException {
    try {
      return this.javaxSession.getTransacted();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getAcknowledgeMode() throws JMSException {
    try {
      return this.javaxSession.getAcknowledgeMode();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void commit() throws JMSException {
    try {
      this.javaxSession.commit();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void rollback() throws JMSException {
    try {
      this.javaxSession.rollback();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() throws JMSException {
    try {
      this.javaxSession.close();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void recover() throws JMSException {
    try {
      this.javaxSession.recover();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageListener getMessageListener() throws JMSException {
    try {
      this.javaxSession.getMessageListener();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
    return this.listener;
  }

  @Override
  public void setMessageListener(MessageListener listener) throws JMSException {
    JavaxMessageListener javaxListener = listener != null ? new JavaxMessageListener(listener) : null;
    try {
      this.javaxSession.setMessageListener(javaxListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
    this.listener = listener;
  }

  @Override
  public void run() {
    this.javaxSession.run();
  }

  @Override
  public MessageProducer createProducer(Destination destination) throws JMSException {
    try {
      return new JakartaMessageProducer(this.javaxSession.createProducer(Wrapper.unwrapObject(destination, javax.jms.Destination.class)));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createConsumer(Destination destination) throws JMSException {
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createConsumer(javaxDestination));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createConsumer(javaxDestination, messageSelector));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) throws JMSException {
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createConsumer(javaxDestination, messageSelector, noLocal));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createSharedConsumer(javaxTopic, sharedSubscriptionName));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName, String messageSelector) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createSharedConsumer(javaxTopic, sharedSubscriptionName, messageSelector));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Queue createQueue(String queueName) throws JMSException {
    try {
      return new JakartaQueue(this.javaxSession.createQueue(queueName));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Topic createTopic(String topicName) throws JMSException {
    try {
      return new JakartaTopic(this.javaxSession.createTopic(topicName));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaTopicSubscriber(this.javaxSession.createDurableSubscriber(javaxTopic, name));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TopicSubscriber createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaTopicSubscriber(this.javaxSession.createDurableSubscriber(javaxTopic, name, messageSelector, noLocal));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createDurableConsumer(Topic topic, String name) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createDurableConsumer(javaxTopic, name));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createDurableConsumer(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createDurableConsumer(javaxTopic, name, messageSelector, noLocal));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createSharedDurableConsumer(Topic topic, String name) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createSharedDurableConsumer(javaxTopic, name));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageConsumer createSharedDurableConsumer(Topic topic, String name, String messageSelector) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaMessageConsumer(this.javaxSession.createSharedDurableConsumer(javaxTopic, name, messageSelector));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueBrowser createBrowser(Queue queue) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueBrowser(this.javaxSession.createBrowser(javaxQueue));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueBrowser(this.javaxSession.createBrowser(javaxQueue, messageSelector));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TemporaryQueue createTemporaryQueue() throws JMSException {
    try {
      return new JakartaTemporaryQueue(this.javaxSession.createTemporaryQueue());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TemporaryTopic createTemporaryTopic() throws JMSException {
    try {
      return new JakartaTemporaryTopic(this.javaxSession.createTemporaryTopic());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void unsubscribe(String name) throws JMSException {
    try {
      this.javaxSession.unsubscribe(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
