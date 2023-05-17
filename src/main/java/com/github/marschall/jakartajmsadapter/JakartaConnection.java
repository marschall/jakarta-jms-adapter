package com.github.marschall.jakartajmsadapter;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionConsumer;
import jakarta.jms.ConnectionMetaData;
import jakarta.jms.Destination;
import jakarta.jms.ExceptionListener;
import jakarta.jms.JMSException;
import jakarta.jms.ServerSessionPool;
import jakarta.jms.Session;
import jakarta.jms.Topic;

sealed class JakartaConnection implements Connection
  permits JakartaQueueConnection {

  private final javax.jms.Connection javaxConnection;

  // Connections support concurrent use
  private volatile ExceptionListener listener;

  JakartaConnection(javax.jms.Connection javaxConnection) {
    this.javaxConnection = javaxConnection;
  }

  @Override
  public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
    try {
      return new JakartaSession(this.javaxConnection.createSession(transacted, acknowledgeMode));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Session createSession(int sessionMode) throws JMSException {
    try {
      return new JakartaSession(this.javaxConnection.createSession(sessionMode));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Session createSession() throws JMSException {
    try {
      return new JakartaSession(this.javaxConnection.createSession());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getClientID() throws JMSException {
    try {
      return this.javaxConnection.getClientID();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setClientID(String clientID) throws JMSException {
    try {
      this.javaxConnection.setClientID(clientID);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionMetaData getMetaData() throws JMSException {
    try {
      return new JakartaConnectionMetaData(this.javaxConnection.getMetaData());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ExceptionListener getExceptionListener() throws JMSException {
    try {
      this.javaxConnection.getExceptionListener();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
    return this.listener;
  }

  @Override
  public void setExceptionListener(ExceptionListener listener) throws JMSException {
    JavaxExceptionListener javaxListener = listener != null ? new JavaxExceptionListener(listener) : null;
    try {
      this.javaxConnection.setExceptionListener(javaxListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
    this.listener = listener;
  }

  @Override
  public void start() throws JMSException {
    try {
      this.javaxConnection.start();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void stop() throws JMSException {
    try {
      this.javaxConnection.stop();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() throws JMSException {
    try {
      this.javaxConnection.close();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector, ServerSessionPool sessionPool, int maxMessages)
          throws JMSException {
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    javax.jms.ServerSessionPool javaxSessionPool = Wrapper.unwrapObject(sessionPool, javax.jms.ServerSessionPool.class);
    try {
      return new JakartaConnectionConsumer(this.javaxConnection.createConnectionConsumer(javaxDestination, messageSelector, javaxSessionPool, maxMessages));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages)
          throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    javax.jms.ServerSessionPool javaxSessionPool = Wrapper.unwrapObject(sessionPool, javax.jms.ServerSessionPool.class);
    try {
      return new JakartaConnectionConsumer(this.javaxConnection.createSharedConnectionConsumer(javaxTopic, subscriptionName, messageSelector, javaxSessionPool, maxMessages));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages)
          throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    javax.jms.ServerSessionPool javaxSessionPool = Wrapper.unwrapObject(sessionPool, javax.jms.ServerSessionPool.class);
    try {
      return new JakartaConnectionConsumer(this.javaxConnection.createDurableConnectionConsumer(javaxTopic, subscriptionName, messageSelector, javaxSessionPool, maxMessages));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages)
          throws JMSException {
    javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
    javax.jms.ServerSessionPool javaxSessionPool = Wrapper.unwrapObject(sessionPool, javax.jms.ServerSessionPool.class);
    try {
      return new JakartaConnectionConsumer(this.javaxConnection.createSharedDurableConnectionConsumer(javaxTopic, subscriptionName, messageSelector, javaxSessionPool, maxMessages));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
