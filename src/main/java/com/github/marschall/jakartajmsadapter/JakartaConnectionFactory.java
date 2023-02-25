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
    try {
      return new JakartaJMSContext(this.javaxConnectionFactory.createContext());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSContext createContext(String userName, String password) {
    try {
      return new JakartaJMSContext(this.javaxConnectionFactory.createContext(userName, password));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSContext createContext(String userName, String password, int sessionMode) {
    try {
      return new JakartaJMSContext(this.javaxConnectionFactory.createContext(userName, password, sessionMode));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSContext createContext(int sessionMode) {
    try {
      return new JakartaJMSContext(this.javaxConnectionFactory.createContext(sessionMode));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

}
