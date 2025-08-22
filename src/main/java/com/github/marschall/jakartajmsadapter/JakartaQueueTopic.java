package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.Topic;

/**
 * Adapts a Java EE destination that implements both {@link javax.jms.Queue} and {@link javax.jms.Topic} to a Jakarta EE destination that
 * implements both {@link Queue} and {@link Topic}.
 */
final class JakartaQueueTopic<D extends javax.jms.Queue & javax.jms.Topic> extends JakartaDestination implements Queue, Topic {

    private final D javaxDestination;

    JakartaQueueTopic(D javaxDestination) {
        super(javaxDestination);
        this.javaxDestination = javaxDestination;
    }

    @Override
    public String getQueueName() throws JMSException {
        try {
            return this.javaxDestination.getQueueName();
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

    @Override
    public String getTopicName() throws JMSException {
        try {
            return this.javaxDestination.getTopicName();
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

}
