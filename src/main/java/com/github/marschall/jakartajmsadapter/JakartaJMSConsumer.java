package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSConsumer;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

final class JakartaJMSConsumer implements JMSConsumer {

  private final javax.jms.JMSConsumer javaxConsumer;
  private MessageListener listener;

  JakartaJMSConsumer(javax.jms.JMSConsumer javaxConsumer) {
    this.javaxConsumer = javaxConsumer;
  }

  @Override
  public String getMessageSelector() {
    try {
      return this.javaxConsumer.getMessageSelector();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageListener getMessageListener() {
    try {
      this.javaxConsumer.getMessageListener();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this.listener;
  }

  @Override
  public void setMessageListener(MessageListener listener) {
    JavaxMessageListener javaxListener = listener != null ? new JavaxMessageListener(listener) : null;
    try {
      this.javaxConsumer.setMessageListener(javaxListener);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    this.listener = listener;
  }

  @Override
  public Message receive() {
    try {
      return JakartaMessage.fromJavax(this.javaxConsumer.receive());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message receive(long timeout) {
    try {
      return JakartaMessage.fromJavax(this.javaxConsumer.receive(timeout));
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message receiveNoWait() {
    try {
      return JakartaMessage.fromJavax(this.javaxConsumer.receiveNoWait());
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() {
    try {
      this.javaxConsumer.close();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public <T> T receiveBody(Class<T> c) {
    try {
      return this.javaxConsumer.receiveBody(c);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public <T> T receiveBody(Class<T> c, long timeout) {
    try {
      return this.javaxConsumer.receiveBody(c, timeout);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public <T> T receiveBodyNoWait(Class<T> c) {
    try {
      return this.javaxConsumer.receiveBodyNoWait(c);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

}
