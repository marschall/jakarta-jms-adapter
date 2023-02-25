package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSRuntimeException;

final class JMSRuntimeExceptionUtil {

  private JMSRuntimeExceptionUtil() {
    throw new AssertionError("not instantiable");
  }

  static JMSRuntimeException adaptException(javax.jms.JMSRuntimeException e) {
    // TODO more exceptions
    return new JMSRuntimeException(e.getMessage(), e.getErrorCode(), e);
  }

}
