package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;

final class JakartaMessageConsumer implements MessageConsumer {

  private final javax.jms.MessageConsumer javaxMessageConsumer;

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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setMessageListener(MessageListener listener) throws JMSException {
    // TODO Auto-generated method stub

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
