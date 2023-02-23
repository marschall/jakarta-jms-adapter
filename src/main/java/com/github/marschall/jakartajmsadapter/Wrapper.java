package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;

interface Wrapper {
  
  <T> T unwrap(Class<T> clazz) throws JMSException;
  
  static <T> T unwrapObject(Object o, Class<T> clazz) throws JMSException {
    if (!(o instanceof Wrapper)) {
      throw new JMSException("not a wrapper: " + o.getClass());
    }
    return ((Wrapper) o).unwrap(clazz);
  }

}
