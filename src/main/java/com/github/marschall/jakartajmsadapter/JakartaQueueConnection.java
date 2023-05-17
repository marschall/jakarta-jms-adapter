package com.github.marschall.jakartajmsadapter;

import jakarta.jms.ConnectionConsumer;
import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.QueueConnection;
import jakarta.jms.QueueSession;
import jakarta.jms.ServerSessionPool;

final class JakartaQueueConnection extends JakartaConnection implements QueueConnection {

  private final javax.jms.QueueConnection javaxQueueConnection;

  JakartaQueueConnection(javax.jms.QueueConnection javaxQueueConnection) {
    super(javaxQueueConnection);
    this.javaxQueueConnection = javaxQueueConnection;
  }

  @Override
  public QueueSession createQueueSession(boolean transacted, int acknowledgeMode) throws JMSException {
    try {
      return new JakartaQueueSession(this.javaxQueueConnection.createQueueSession(transacted, acknowledgeMode));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public ConnectionConsumer createConnectionConsumer(Queue queue, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
    javax.jms.Queue javaxQueue = Wrapper.unwrapObject(queue, javax.jms.Queue.class);
    javax.jms.ServerSessionPool javaxSessionPool = Wrapper.unwrapObject(sessionPool, javax.jms.ServerSessionPool.class);
    try {
      return new JakartaConnectionConsumer(this.javaxQueueConnection.createConnectionConsumer(javaxQueue, messageSelector, javaxSessionPool, maxMessages));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
