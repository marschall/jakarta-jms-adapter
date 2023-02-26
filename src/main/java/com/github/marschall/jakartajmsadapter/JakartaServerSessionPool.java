package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.JMSException;
import jakarta.jms.ServerSession;
import jakarta.jms.ServerSessionPool;

final class JakartaServerSessionPool implements ServerSessionPool, Wrapper {

  private final javax.jms.ServerSessionPool serverSessionPool;

  JakartaServerSessionPool(javax.jms.ServerSessionPool serverSessionPool) {
    Objects.requireNonNull(serverSessionPool);
    this.serverSessionPool = serverSessionPool;
  }

  @Override
  public ServerSession getServerSession() throws JMSException {
    try {
      return new JakartaServerSession(this.serverSessionPool.getServerSession());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Object getJavaxObject() {
    return this.serverSessionPool;
  }

}
