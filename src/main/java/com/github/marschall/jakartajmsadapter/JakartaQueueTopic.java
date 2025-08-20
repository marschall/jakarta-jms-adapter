package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.Topic;

/**
 * Adapts a Java EE destination that implements both {@link javax.jms.Queue} and {@link javax.jms.Topic} to a Jakarta EE destination that
 * implements both {@link Queue} and {@link Topic}.
 * <p>
 * {@code public} for cases where a queue is looked up through JNDI.
 */
public final class JakartaQueueTopic extends JakartaDestination implements Queue, Topic {

    private final javax.jms.Queue javaxQueue;
    private final javax.jms.Topic javaxTopic;

    public JakartaQueueTopic(javax.jms.Destination javaxDestination) {
        super(javaxDestination);
        if (!(javaxDestination instanceof javax.jms.Queue javaxQueue && javaxDestination instanceof javax.jms.Topic javaxTopic)) {
            throw new IllegalArgumentException("does not implement both destinations: " + javaxDestination.getClass());
        }
        this.javaxQueue = javaxQueue;
        this.javaxTopic = javaxTopic;
    }

    @Override
    public String getQueueName() throws JMSException {
        try {
            return this.javaxQueue.getQueueName();
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

    @Override
    public String getTopicName() throws JMSException {
        try {
            return this.javaxTopic.getTopicName();
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

}
