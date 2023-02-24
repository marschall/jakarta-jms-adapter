package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;

abstract sealed class JakartaDestination implements Destination, Wrapper
    permits JakartaQueue, JakartaTopic {

  private final javax.jms.Destination javaxDestination;

  JakartaDestination(javax.jms.Destination javaxDestination) {
    Objects.requireNonNull(javaxDestination);
    this.javaxDestination = javaxDestination;
  }

  @Override
  public Object getJavaxObject() {
    return this.javaxDestination;
  }

  @Override
  public String toString() {
    return this.javaxDestination.toString();
  }

  static Destination fromJavax(javax.jms.Destination destination) throws JMSException {
    if (destination instanceof javax.jms.Topic topic) {
      if (topic instanceof javax.jms.TemporaryTopic) {
        throw new JMSException("temporary topics not yet supported");
      }
      return new JakartaTopic(topic);
    } else if (destination instanceof javax.jms.Queue queue) {
      if (queue instanceof javax.jms.TemporaryQueue) {
        throw new JMSException("temporary queues not yet supported");
      }
      return new JakartaQueue(queue);
    } else {
      throw new JMSException("unknown destination type: " + destination.getClass());
    }
  }

}
