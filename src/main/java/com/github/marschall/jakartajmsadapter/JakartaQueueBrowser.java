package com.github.marschall.jakartajmsadapter;

import java.util.Enumeration;

import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.QueueBrowser;

final class JakartaQueueBrowser implements QueueBrowser {

  private final javax.jms.QueueBrowser javaxQueueBrowser;

  JakartaQueueBrowser(javax.jms.QueueBrowser queueBrowser) {
    this.javaxQueueBrowser = queueBrowser;
  }

  @Override
  public Queue getQueue() throws JMSException {
    try {
      return new JakartaQueue(this.javaxQueueBrowser.getQueue());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getMessageSelector() throws JMSException {
    try {
      return this.javaxQueueBrowser.getMessageSelector();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Enumeration getEnumeration() throws JMSException {
    try {
      return new JakartaEnumeration(this.javaxQueueBrowser.getEnumeration());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() throws JMSException {
    try {
      this.javaxQueueBrowser.close();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @SuppressWarnings("rawtypes")
  static final class JakartaEnumeration implements Enumeration {

    private final Enumeration javaxEnumeration;

    JakartaEnumeration(Enumeration javaxEnumeration) {
      this.javaxEnumeration = javaxEnumeration;
    }

    @Override
    public boolean hasMoreElements() {
      return this.javaxEnumeration.hasMoreElements();
    }

    @Override
    public Object nextElement() {
      Object nextElement = this.javaxEnumeration.nextElement();
      if (nextElement instanceof javax.jms.Message message) {
        return JakartaMessage.fromJavax(message);
      } else {
        return nextElement;
      }
    }

  }

}
