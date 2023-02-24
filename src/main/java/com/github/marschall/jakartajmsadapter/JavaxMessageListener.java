package com.github.marschall.jakartajmsadapter;

import javax.jms.Message;

import jakarta.jms.MessageListener;

final class JavaxMessageListener implements javax.jms.MessageListener {

  private final MessageListener jakartaMessageListener;

  JavaxMessageListener(MessageListener jakartaMessageListener) {
    this.jakartaMessageListener = jakartaMessageListener;
  }

  @Override
  public void onMessage(Message message) {
    // TODO Auto-generated method stub

  }



}
