package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;

sealed class JakartaQueue extends JakartaDestination implements Queue
  permits JakartaTemporaryQueue {

  private final javax.jms.Queue javaxQueue;

  JakartaQueue(javax.jms.Queue javaxQueue) {
    super(javaxQueue);
    this.javaxQueue = javaxQueue;
  }

  @Override
  public String getQueueName() throws JMSException {
    try {
      return this.javaxQueue.getQueueName();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
