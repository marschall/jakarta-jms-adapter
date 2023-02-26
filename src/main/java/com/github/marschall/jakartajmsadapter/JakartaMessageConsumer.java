package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;

sealed class JakartaMessageConsumer implements MessageConsumer
  permits JakartaTopicSubscriber {

  private final javax.jms.MessageConsumer javaxMessageConsumer;
  private MessageListener listener;

  JakartaMessageConsumer(javax.jms.MessageConsumer javaxMessageConsumer) {
    this.javaxMessageConsumer = javaxMessageConsumer;
  }

  @Override
  public String getMessageSelector() throws JMSException {
    try {
      return this.javaxMessageConsumer.getMessageSelector();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public MessageListener getMessageListener() throws JMSException {
    try {
      this.javaxMessageConsumer.getMessageListener();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
    return this.listener;
  }

  @Override
  public void setMessageListener(MessageListener listener) throws JMSException {
    this.listener = listener;
    JavaxMessageListener javaxListener = listener != null ? new JavaxMessageListener(listener) : null;
    try {
      this.javaxMessageConsumer.setMessageListener(javaxListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message receive() throws JMSException {
    try {
      return JakartaMessage.fromJavax(this.javaxMessageConsumer.receive());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message receive(long timeout) throws JMSException {
    try {
      return JakartaMessage.fromJavax(this.javaxMessageConsumer.receive(timeout));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Message receiveNoWait() throws JMSException {
    try {
      return JakartaMessage.fromJavax(this.javaxMessageConsumer.receiveNoWait());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() throws JMSException {
    try {
      this.javaxMessageConsumer.close();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
