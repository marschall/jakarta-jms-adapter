package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;

/**
 * Wraps a javax.jms object and adapts it to a jakarta.jms object.
 *
 */
interface Wrapper {

  Object getJavaxObject();

  static <T> T unwrapObject(Object o, Class<T> clazz) throws JMSException {
    if (!(o instanceof Wrapper)) {
      throw new JMSException("not a wrapper: " + o.getClass());
    }
    Object javaxObject = ((Wrapper) o).getJavaxObject();
    if (!clazz.isInstance(javaxObject)) {
      throw new JMSException(o.getClass().getName() + " is not an instance of: " + clazz.getName());
    }
    return clazz.cast(javaxObject);
  }

}
