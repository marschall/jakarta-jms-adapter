package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;

/**
 * Adapts a {@link javax.jms.ConnectionFactory} to a {@link jakarta.jms.ConnectionFactory}
 */
public final class JakartaConnectionFactory implements ConnectionFactory {

  private final javax.jms.ConnectionFactory javaxConnectionFactory;

  public JakartaConnectionFactory(javax.jms.ConnectionFactory javaxConnectionFactory) {
    Objects.requireNonNull(javaxConnectionFactory);
    this.javaxConnectionFactory = javaxConnectionFactory;
  }

  @Override
  public Connection createConnection() throws JMSException {
    try {
      return new JakartaConnection(this.javaxConnectionFactory.createConnection());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Connection createConnection(String userName, String password) throws JMSException {
    try {
      return new JakartaConnection(this.javaxConnectionFactory.createConnection(userName, password));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSContext createContext() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSContext createContext(String userName, String password) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSContext createContext(String userName, String password,
          int sessionMode) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSContext createContext(int sessionMode) {
    // TODO Auto-generated method stub
    return null;
  }

}
