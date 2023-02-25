package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;

final class JMSExceptionUtil {

  private JMSExceptionUtil() {
    throw new AssertionError("not instantiable");
  }

  static JMSException adaptException(javax.jms.JMSException e) {
    // TODO more exceptions
    return new JMSException(e.getMessage(), e.getErrorCode(), e);
  }

}
