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

final class JakartaConnection implements Connection {

  private final javax.jms.Connection javaxConnection;

  JakartaConnection(javax.jms.Connection javaxConnection) {
    this.javaxConnection = javaxConnection;
  }

  @Override
  public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Session createSession(int sessionMode) throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Session createSession() throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getClientID() throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setClientID(String clientID) throws JMSException {
    // TODO Auto-generated method stub

  }

  @Override
  public ConnectionMetaData getMetaData() throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ExceptionListener getExceptionListener() throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setExceptionListener(ExceptionListener listener) throws JMSException {
    // TODO Auto-generated method stub

  }

  @Override
  public void start() throws JMSException {
    // TODO Auto-generated method stub

  }

  @Override
  public void stop() throws JMSException {
    // TODO Auto-generated method stub

  }

  @Override
  public void close() throws JMSException {
    // TODO Auto-generated method stub

  }

  @Override
  public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector,
      ServerSessionPool sessionPool, int maxMessages) throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String subscriptionName, String messageSelector,
      ServerSessionPool sessionPool, int maxMessages) throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName,
      String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String subscriptionName,
      String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
    // TODO Auto-generated method stub
    return null;
  }

}
