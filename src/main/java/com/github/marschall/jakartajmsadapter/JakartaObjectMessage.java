package com.github.marschall.jakartajmsadapter;

import java.io.Serializable;

import jakarta.jms.JMSException;
import jakarta.jms.ObjectMessage;

final class JakartaObjectMessage extends JakartaMessage implements ObjectMessage {

  private final javax.jms.ObjectMessage javaxMessage;

  JakartaObjectMessage(javax.jms.ObjectMessage javaxMessage) {
    super(javaxMessage);
    this.javaxMessage = javaxMessage;
  }

  @Override
  public void setObject(Serializable object) throws JMSException {
    try {
      javaxMessage.setObject(object);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Serializable getObject() throws JMSException {
    try {
      return javaxMessage.getObject();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
