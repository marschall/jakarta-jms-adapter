package com.github.marschall.jakartajmsadapter;

import javax.jms.Queue;
import javax.jms.Topic;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.JMSRuntimeException;

/**
 * Wraps a javax.jms object and adapts it to a jakarta.jms object.
 */
public interface Wrapper {

  /**
   * {@return the underlying javax.jms object}
   */
  Object getJavaxObject();

  /**
   * Adapts a Java EE {@link javax.jms.Destination} to a Jakarta EE {@link Destination}.
   * <p>
   * {@code public} for cases where a destination is looked up through JNDI.
   * 
   * @param destination the destination to adapt,
   *        must either be a {@link javax.jms.Topic} or {@link javax.jms.Queue},
   *        {@code null} allowed
   * @return the adapted destination,
   *         will be a {@link Topic} if {@code destination} is a {@link javax.jms.Topic},
   *         will be a {@link Queue} if {@code destination} is a {@link javax.jms.Queue},
   *         will be a {@code null} if {@code destination} is {@code null}
   */
  static Destination fromJavaxDestination(javax.jms.Destination destination) {
    if (destination == null) {
      // JMSReplyTo or JMSDestination can be null
      return null;
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
      throw new IllegalArgumentException("unknown destination type: " + destination.getClass());
    }
  }

  static <T> T unwrapObject(Object o, Class<T> clazz) throws JMSException {
    if (o == null) {
      return null;
    }
    if (!(o instanceof Wrapper w)) {
      throw new JMSException("not a wrapper: " + o.getClass());
    }
    Object javaxObject = w.getJavaxObject();
    if (!clazz.isInstance(javaxObject)) {
      throw new JMSException(o.getClass().getName() + " is not an instance of: " + clazz.getName());
    }
    return clazz.cast(javaxObject);
  }

  static <T> T unwrapUnchecked(Object o, Class<T> clazz) throws JMSRuntimeException {
    if (o == null) {
      return null;
    }
    if (!(o instanceof Wrapper w)) {
      throw new JMSRuntimeException("not a wrapper: " + o.getClass());
    }
    Object javaxObject = w.getJavaxObject();
    if (!clazz.isInstance(javaxObject)) {
      throw new JMSRuntimeException(o.getClass().getName() + " is not an instance of: " + clazz.getName());
    }
    return clazz.cast(javaxObject);
  }

}
