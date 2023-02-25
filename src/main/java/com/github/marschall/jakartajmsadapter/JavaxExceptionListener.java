package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.ExceptionListener;
import jakarta.jms.JMSException;

final class JavaxExceptionListener implements javax.jms.ExceptionListener {

  private final ExceptionListener jakartaExceptionListener;

  JavaxExceptionListener(ExceptionListener jakartaExceptionListener) {
    Objects.requireNonNull(jakartaExceptionListener);
    this.jakartaExceptionListener = jakartaExceptionListener;
  }

  @Override
  public void onException(javax.jms.JMSException exception) {
    JMSException jakartaException = JMSExceptionUtil.adaptException(exception);
    this.jakartaExceptionListener.onException(jakartaException);
  }

}
