package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.CompletionListener;
import jakarta.jms.Message;

final class JavaxCompletionListener implements javax.jms.CompletionListener {

  private final CompletionListener jakartaCompletionListener;

  JavaxCompletionListener(CompletionListener jakartaCompletionListener) {
    Objects.requireNonNull(jakartaCompletionListener);
    this.jakartaCompletionListener = jakartaCompletionListener;
  }

  @Override
  public void onCompletion(javax.jms.Message message) {
    Message jakartaMessage = JakartaMessage.fromJavax(message);
    this.jakartaCompletionListener.onCompletion(jakartaMessage);
  }

  @Override
  public void onException(javax.jms.Message message, Exception exception) {
    Message jakartaMessage = JakartaMessage.fromJavax(message);
    Exception adapted;
    if (exception instanceof javax.jms.JMSException jmsException) {
      adapted = JMSExceptionUtil.adaptException(jmsException);
    } else if (exception instanceof javax.jms.JMSRuntimeException jmsRuntimeException) {
      adapted = JMSRuntimeExceptionUtil.adaptException(jmsRuntimeException);
    } else {
      adapted = exception;
    }
    this.jakartaCompletionListener.onException(jakartaMessage, adapted);
  }

}
