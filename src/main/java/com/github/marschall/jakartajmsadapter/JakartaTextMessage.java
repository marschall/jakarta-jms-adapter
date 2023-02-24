package com.github.marschall.jakartajmsadapter;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;

final class JakartaTextMessage extends JakartaMessage implements TextMessage {

  private final javax.jms.TextMessage javaxMessage;

  JakartaTextMessage(javax.jms.TextMessage javaxMessage) {
    super(javaxMessage);
    this.javaxMessage = javaxMessage;
  }

  @Override
  public void setText(String string) throws JMSException {
    try {
      this.javaxMessage.setText(string);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getText() throws JMSException {
    try {
      return this.javaxMessage.getText();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
