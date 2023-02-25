package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;

final class JavaxMessageListener implements javax.jms.MessageListener {

  private final MessageListener jakartaMessageListener;

  JavaxMessageListener(MessageListener jakartaMessageListener) {
    Objects.requireNonNull(jakartaMessageListener);
    this.jakartaMessageListener = jakartaMessageListener;
  }

  @Override
  public void onMessage(javax.jms.Message message) {
    Message jakartaMessage = JakartaMessage.fromJavax(message);
    this.jakartaMessageListener.onMessage(jakartaMessage);
  }

}
