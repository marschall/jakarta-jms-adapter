package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.QueueReceiver;

final class JakartaQueueReceiver extends JakartaMessageConsumer implements QueueReceiver {

  private final javax.jms.QueueReceiver javaxQueueReceiver;

  JakartaQueueReceiver(javax.jms.QueueReceiver javaxQueueReceiver) {
    super(javaxQueueReceiver);
    this.javaxQueueReceiver = javaxQueueReceiver;
  }

  @Override
  public Queue getQueue() throws JMSException {
    try {
      return new JakartaQueue(this.javaxQueueReceiver.getQueue());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
