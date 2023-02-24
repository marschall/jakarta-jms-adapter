package com.github.marschall.jakartajmsadapter;

import javax.jms.Message;

import jakarta.jms.CompletionListener;

final class JavaxCompletionListener implements javax.jms.CompletionListener {

  private final CompletionListener jakartaCompletionListener;

  JavaxCompletionListener(CompletionListener jakartaCompletionListener) {
    this.jakartaCompletionListener = jakartaCompletionListener;
  }

  @Override
  public void onCompletion(Message message) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onException(Message message, Exception exception) {
    // TODO Auto-generated method stub
  }

}
