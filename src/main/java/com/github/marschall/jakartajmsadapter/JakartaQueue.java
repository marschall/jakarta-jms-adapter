package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;

/**
 * Adapts a Java EE {@link javax.jms.Queue} to a Jakarta EE {@link Queue}.
 * <p>
 * {@code public} for cases where a queue is looked up through JNDI.
 */
public sealed class JakartaQueue extends JakartaDestination implements Queue
  permits JakartaTemporaryQueue {

  private final javax.jms.Queue javaxQueue;

  public JakartaQueue(javax.jms.Queue javaxQueue) {
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
