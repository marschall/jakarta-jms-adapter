package com.github.marschall.jakartajmsadapter;

import jakarta.jms.ConnectionConsumer;
import jakarta.jms.JMSException;
import jakarta.jms.ServerSessionPool;
import jakarta.jms.Topic;
import jakarta.jms.TopicConnection;
import jakarta.jms.TopicSession;

final class JakartaTopicConnection extends JakartaConnection implements TopicConnection {

  private final javax.jms.TopicConnection javaxTopicConnection;

  JakartaTopicConnection(javax.jms.TopicConnection javaxTopicConnection) {
    super(javaxTopicConnection);
    this.javaxTopicConnection = javaxTopicConnection;
  }

  @Override
  public TopicSession createTopicSession(boolean transacted, int acknowledgeMode) throws JMSException {
    try {
      return new JakartaTopicSession(this.javaxTopicConnection.createTopicSession(transacted, acknowledgeMode));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionConsumer createConnectionConsumer(Topic Topic, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(Topic, javax.jms.Topic.class);
    javax.jms.ServerSessionPool javaxSessionPool = Wrapper.unwrapObject(sessionPool, javax.jms.ServerSessionPool.class);
    try {
      return new JakartaConnectionConsumer(this.javaxTopicConnection.createConnectionConsumer(javaxTopic, messageSelector, javaxSessionPool, maxMessages));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
