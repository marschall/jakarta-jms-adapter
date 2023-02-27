package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSRuntimeException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

final class JakartaJMSConsumer implements JMSConsumer {

  private final javax.jms.JMSConsumer javaxConsumer;

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
  public MessageListener getMessageListener() throws JMSRuntimeException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setMessageListener(MessageListener listener) throws JMSRuntimeException {
    // TODO Auto-generated method stub

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
