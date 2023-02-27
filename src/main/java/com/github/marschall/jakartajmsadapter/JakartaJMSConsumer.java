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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Message receive(long timeout) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Message receiveNoWait() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }

  @Override
  public <T> T receiveBody(Class<T> c) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T receiveBody(Class<T> c, long timeout) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T receiveBodyNoWait(Class<T> c) {
    // TODO Auto-generated method stub
    return null;
  }

}
