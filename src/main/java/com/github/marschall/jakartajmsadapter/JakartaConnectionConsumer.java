package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.ConnectionConsumer;
import jakarta.jms.JMSException;
import jakarta.jms.ServerSessionPool;

final class JakartaConnectionConsumer implements ConnectionConsumer {

  private final javax.jms.ConnectionConsumer connectionConsumer;

  JakartaConnectionConsumer(javax.jms.ConnectionConsumer connectionConsumer) {
    Objects.requireNonNull(connectionConsumer);
    this.connectionConsumer = connectionConsumer;
  }

  @Override
  public ServerSessionPool getServerSessionPool() throws JMSException {
    try {
      return new JakartaServerSessionPool(this.connectionConsumer.getServerSessionPool());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() throws JMSException {
    try {
      this.connectionConsumer.close();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
