package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.TemporaryQueue;

final class JakartaTemporaryQueue extends JakartaQueue implements TemporaryQueue {

  private final javax.jms.TemporaryQueue javaxTemporaryQueue;

  JakartaTemporaryQueue(javax.jms.TemporaryQueue javaxTemporaryQueue) {
    super(javaxTemporaryQueue);
    this.javaxTemporaryQueue = javaxTemporaryQueue;
  }

  @Override
  public void delete() throws JMSException {
    try {
      this.javaxTemporaryQueue.delete();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
