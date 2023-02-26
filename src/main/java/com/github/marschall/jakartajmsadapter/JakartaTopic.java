package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Topic;

sealed class JakartaTopic extends JakartaDestination implements Topic
  permits JakartaTemporaryTopic {

  private final javax.jms.Topic javaxTopic;

  JakartaTopic(javax.jms.Topic javaxTopic) {
    super(javaxTopic);
    this.javaxTopic = javaxTopic;
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
