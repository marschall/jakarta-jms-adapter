package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.QueueConnection;
import jakarta.jms.QueueConnectionFactory;

/**
 * Adapts a {@link javax.jms.QueueConnectionFactory} to a {@link jakarta.jms.QueueConnectionFactory}
 */
public final class JakartaQueueConnectionFactory extends JakartaConnectionFactory implements QueueConnectionFactory {

  private final javax.jms.QueueConnectionFactory javaxQueueConnectionFactory;

  /**
   * Constructs a new {@link JakartaQueueConnectionFactory}
   *
   * @param javaxQueueConnectionFactory the javax connection factory to adapt, not {@code null}
   * @throws NullPointerException if {@code javaxQueueConnectionFactory} is {@code null}
   */
  public JakartaQueueConnectionFactory(javax.jms.QueueConnectionFactory javaxQueueConnectionFactory) {
    super(javaxQueueConnectionFactory);
    this.javaxQueueConnectionFactory = javaxQueueConnectionFactory;
  }

  @Override
  public QueueConnection createQueueConnection() throws JMSException {
    try {
      return new JakartaQueueConnection(this.javaxQueueConnectionFactory.createQueueConnection());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public QueueConnection createQueueConnection(String userName, String password) throws JMSException {
    try {
      return new JakartaQueueConnection(this.javaxQueueConnectionFactory.createQueueConnection(userName, password));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
