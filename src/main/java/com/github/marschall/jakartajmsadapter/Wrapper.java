package com.github.marschall.jakartajmsadapter;

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

  static <T> T unwrapObject(Object o, Class<T> clazz) throws JMSException {
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
