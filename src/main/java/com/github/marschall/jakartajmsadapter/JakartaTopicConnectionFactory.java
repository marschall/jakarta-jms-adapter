package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.TopicConnection;
import jakarta.jms.TopicConnectionFactory;

/**
 * Adapts a {@link javax.jms.TopicConnectionFactory} to a {@link TopicConnectionFactory}
 */
public final class JakartaTopicConnectionFactory extends JakartaConnectionFactory implements TopicConnectionFactory {

  private final javax.jms.TopicConnectionFactory javaxTopicConnectionFactory;

  /**
   * Constructs a new {@link JakartaTopicConnectionFactory}
   *
   * @param javaxTopicConnectionFactory the javax connection factory to adapt, not {@code null}
   * @throws NullPointerException if {@code javaxTopicConnectionFactory} is {@code null}
   */
  public JakartaTopicConnectionFactory(javax.jms.TopicConnectionFactory javaxTopicConnectionFactory) {
    super(javaxTopicConnectionFactory);
    this.javaxTopicConnectionFactory = javaxTopicConnectionFactory;
  }

  @Override
  public TopicConnection createTopicConnection() throws JMSException {
    try {
      return new JakartaTopicConnection(this.javaxTopicConnectionFactory.createTopicConnection());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public TopicConnection createTopicConnection(String userName, String password) throws JMSException {
    try {
      return new JakartaTopicConnection(this.javaxTopicConnectionFactory.createTopicConnection(userName, password));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
