package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.ServerSession;
import jakarta.jms.Session;

final class JakartaServerSession implements ServerSession {

  private final javax.jms.ServerSession serverSession;

  JakartaServerSession(javax.jms.ServerSession serverSession) {
    this.serverSession = serverSession;
  }

  @Override
  public Session getSession() throws JMSException {
    try {
      return new JakartaSession(this.serverSession.getSession());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void start() throws JMSException {
    try {
      this.serverSession.start();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
