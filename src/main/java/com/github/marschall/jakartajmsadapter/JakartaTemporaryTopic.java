package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.TemporaryTopic;

final class JakartaTemporaryTopic extends JakartaTopic implements TemporaryTopic {

  private final javax.jms.TemporaryTopic javaxTemporaryTopic;

  JakartaTemporaryTopic(javax.jms.TemporaryTopic javaxTemporaryTopic) {
    super(javaxTemporaryTopic);
    this.javaxTemporaryTopic = javaxTemporaryTopic;
  }

  @Override
  public void delete() throws JMSException {
    try {
      this.javaxTemporaryTopic.delete();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
