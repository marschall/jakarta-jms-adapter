package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;

/**
 * Adapts a Java EE {@link javax.jms.Destination} to a Jakarta EE {@link Destination}.
 * <p>
 * {@code public} for cases where a destination is looked up through JNDI.
 */
public abstract sealed class JakartaDestination implements Destination, Wrapper
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

public static Destination fromJavax(javax.jms.Destination destination) throws JMSException {
    if (destination == null) {
      return (Destination) null;
    }
    if (destination instanceof javax.jms.Topic topic) {
      if (topic instanceof javax.jms.TemporaryTopic temporaryTopic) {
        return new JakartaTemporaryTopic(temporaryTopic);
      }
      return new JakartaTopic(topic);
    } else if (destination instanceof javax.jms.Queue queue) {
      if (queue instanceof javax.jms.TemporaryQueue temporaryQueue) {
        return new JakartaTemporaryQueue(temporaryQueue);
      }
      return new JakartaQueue(queue);
    } else {
      throw new JMSException("unknown destination type: " + destination.getClass());
    }
  }

}
