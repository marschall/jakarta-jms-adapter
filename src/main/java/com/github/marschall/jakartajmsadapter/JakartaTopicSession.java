package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Topic;
import jakarta.jms.TopicPublisher;
import jakarta.jms.TopicSession;
import jakarta.jms.TopicSubscriber;

final class JakartaTopicSession extends JakartaSession implements TopicSession {

  private final javax.jms.TopicSession javaxTopicSession;

  JakartaTopicSession(javax.jms.TopicSession javaxTopicSession) {
    super(javaxTopicSession);
    this.javaxTopicSession = javaxTopicSession;
  }

  @Override
  public TopicSubscriber createSubscriber(Topic topic) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaTopicSubscriber(this.javaxTopicSession.createSubscriber(javaxTopic));
    } catch (javax.jms.JMSException e) {
        throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TopicSubscriber createSubscriber(Topic topic, String messageSelector, boolean noLocal) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    try {
      return new JakartaTopicSubscriber(this.javaxTopicSession.createSubscriber(javaxTopic, messageSelector, noLocal));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TopicPublisher createPublisher(Topic topic) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
      try {
          return new JakartaTopicPublisher(this.javaxTopicSession.createPublisher(javaxTopic));
      } catch (javax.jms.JMSException e) {
          throw JMSExceptionUtil.adaptException(e);
      }
  }
}
