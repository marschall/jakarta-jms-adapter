package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Topic;
import jakarta.jms.TopicPublisher;

final class JakartaTopicPublisher extends JakartaMessageProducer implements TopicPublisher {

    private final javax.jms.TopicPublisher javaxTopicPublisher;

    JakartaTopicPublisher(javax.jms.TopicPublisher javaxTopicPublisher) {
        super(javaxTopicPublisher);
        this.javaxTopicPublisher = javaxTopicPublisher;
    }

    @Override
    public Topic getTopic() throws JMSException {
        try {
            return new JakartaTopic(this.javaxTopicPublisher.getTopic());
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

    @Override
    public void publish(Message message) throws JMSException {
        javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
        try {
            this.javaxTopicPublisher.send(javaxMessage);
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

    @Override
    public void publish(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
        try {
            this.javaxTopicPublisher.send(javaxMessage, deliveryMode, priority, timeToLive);
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

    @Override
    public void publish(Topic topic, Message message) throws JMSException {
        javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
        javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
        try {
            this.javaxTopicPublisher.send(javaxTopic, javaxMessage);
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }

    @Override
    public void publish(Topic topic, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
        javax.jms.Topic javaxTopic = Wrapper.unwrapObject(topic, javax.jms.Topic.class);
        javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
        try {
            this.javaxTopicPublisher.send(javaxTopic, javaxMessage, deliveryMode, priority, timeToLive);
        } catch (javax.jms.JMSException e) {
            throw JMSExceptionUtil.adaptException(e);
        }
    }
}
