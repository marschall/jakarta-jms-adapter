package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.QueueReceiver;
import jakarta.jms.QueueSender;
import jakarta.jms.QueueSession;

final class JakartaQueueSession extends JakartaSession implements QueueSession {

  private final javax.jms.QueueSession javaxQueueSession;

  JakartaQueueSession(javax.jms.QueueSession javaxQueueSession) {
    super(javaxQueueSession);
    this.javaxQueueSession = javaxQueueSession;
  }

  @Override
  public QueueReceiver createReceiver(Queue queue) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueReceiver(this.javaxQueueSession.createReceiver(javaxQueue));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueReceiver createReceiver(Queue queue, String messageSelector) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueReceiver(this.javaxQueueSession.createReceiver(javaxQueue, messageSelector));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueSender createSender(Queue queue) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    try {
      return new JakartaQueueSender(this.javaxQueueSession.createSender(javaxQueue));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
