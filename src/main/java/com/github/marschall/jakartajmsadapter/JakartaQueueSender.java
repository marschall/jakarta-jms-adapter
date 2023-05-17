package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Queue;
import jakarta.jms.QueueSender;

final class JakartaQueueSender extends JakartaMessageProducer implements QueueSender {

  private final javax.jms.QueueSender javaxQueueSender;

  JakartaQueueSender(javax.jms.QueueSender javaxQueueSender) {
    super(javaxQueueSender);
    this.javaxQueueSender = javaxQueueSender;
  }

  @Override
  public Queue getQueue() throws JMSException {
    try {
      return new JakartaQueue(this.javaxQueueSender.getQueue());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Queue queue, Message message) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(queue, javax.jms.Message.class);
    try {
      this.javaxQueueSender.send(javaxQueue, javaxMessage);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Queue queue, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(queue, javax.jms.Message.class);
    try {
      this.javaxQueueSender.send(javaxQueue, javaxMessage, deliveryMode, priority, timeToLive);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
