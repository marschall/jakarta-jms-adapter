package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.QueueConnection;
import jakarta.jms.QueueConnectionFactory;
import jakarta.jms.TopicConnection;
import jakarta.jms.TopicConnectionFactory;

/**
 * Adapts a factory that implements both {@link javax.jms.QueueConnectionFactory} and  {@link javax.jms.TopicConnectionFactory} to a
 * factory that implements both {@link jakarta.jms.QueueConnectionFactory} and {@link jakarta.jms.TopicConnectionFactory}
 */
public final class JakartaQueueTopicConnectionFactory extends JakartaConnectionFactory
        implements QueueConnectionFactory, TopicConnectionFactory {

    private final javax.jms.QueueConnectionFactory javaxQueueConnectionFactory;
    private final javax.jms.TopicConnectionFactory javaxTopicConnectionFactory;

    /**
     * Constructs a new {@link JakartaQueueTopicConnectionFactory}
     *
     * @param javaxQueueTopicConnectionFactory the javax connection factory to adapt, not {@code null}
     * @throws NullPointerException if {@code javaxQueueConnectionFactory} is {@code null}
     */
    public JakartaQueueTopicConnectionFactory(javax.jms.ConnectionFactory javaxQueueTopicConnectionFactory) {
        super(javaxQueueTopicConnectionFactory);
        if (!(javaxQueueTopicConnectionFactory instanceof javax.jms.QueueConnectionFactory javaxQueueConnectionFactory &&
                javaxQueueTopicConnectionFactory instanceof javax.jms.TopicConnectionFactory javaxTopicConnectionFactory)) {
            throw new IllegalArgumentException("does not implement both connection factories: " +
                    javaxQueueTopicConnectionFactory.getClass());
        }
        this.javaxQueueConnectionFactory = javaxQueueConnectionFactory;
        this.javaxTopicConnectionFactory = javaxTopicConnectionFactory;
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
