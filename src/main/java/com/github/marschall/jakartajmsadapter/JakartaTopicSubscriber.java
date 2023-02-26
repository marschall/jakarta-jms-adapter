package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Topic;
import jakarta.jms.TopicSubscriber;

final class JakartaTopicSubscriber extends JakartaMessageConsumer implements TopicSubscriber {

  private final javax.jms.TopicSubscriber javaxTopicSubscriber;

  JakartaTopicSubscriber(javax.jms.TopicSubscriber javaxTopicSubscriber) {
    super(javaxTopicSubscriber);
    this.javaxTopicSubscriber = javaxTopicSubscriber;
  }

  @Override
  public Topic getTopic() throws JMSException {
    try {
      return new JakartaTopic(this.javaxTopicSubscriber.getTopic());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getNoLocal() throws JMSException {
    try {
      return this.javaxTopicSubscriber.getNoLocal();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
