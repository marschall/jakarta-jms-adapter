package com.github.marschall.jakartajmsadapter;

import jakarta.jms.CompletionListener;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageProducer;

final class JakartaMessageProducer implements MessageProducer {

  private final javax.jms.MessageProducer javaxMessageProducer;

  JakartaMessageProducer(javax.jms.MessageProducer javaxMessageProducer) {
    this.javaxMessageProducer = javaxMessageProducer;
  }

  @Override
  public void setDisableMessageID(boolean value) throws JMSException {
    try {
      this.javaxMessageProducer.setDisableMessageID(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getDisableMessageID() throws JMSException {
    try {
      return this.javaxMessageProducer.getDisableMessageID();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setDisableMessageTimestamp(boolean value) throws JMSException {
    try {
      this.javaxMessageProducer.setDisableMessageTimestamp(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getDisableMessageTimestamp() throws JMSException {
    try {
      return this.javaxMessageProducer.getDisableMessageTimestamp();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setDeliveryMode(int deliveryMode) throws JMSException {
    try {
      this.javaxMessageProducer.setDeliveryMode(deliveryMode);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getDeliveryMode() throws JMSException {
    try {
      return this.javaxMessageProducer.getDeliveryMode();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setPriority(int defaultPriority) throws JMSException {
    try {
      this.javaxMessageProducer.setPriority(defaultPriority);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getPriority() throws JMSException {
    try {
      return this.javaxMessageProducer.getPriority();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setTimeToLive(long timeToLive) throws JMSException {
    try {
      this.javaxMessageProducer.setTimeToLive(timeToLive);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getTimeToLive() throws JMSException {
    try {
      return this.javaxMessageProducer.getTimeToLive();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setDeliveryDelay(long deliveryDelay) throws JMSException {
    try {
      this.javaxMessageProducer.setDeliveryDelay(deliveryDelay);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getDeliveryDelay() throws JMSException {
    try {
      return this.javaxMessageProducer.getDeliveryDelay();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Destination getDestination() throws JMSException {
    try {
      return JakartaDestination.fromJavax(this.javaxMessageProducer.getDestination());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void close() throws JMSException {
    try {
      this.javaxMessageProducer.close();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Message message) throws JMSException {
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    try {
      this.javaxMessageProducer.send(javaxMessage);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    try {
      this.javaxMessageProducer.send(javaxMessage, deliveryMode, priority, timeToLive);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Destination destination, Message message) throws JMSException {
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    try {
      this.javaxMessageProducer.send(javaxDestination, javaxMessage);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    try {
      this.javaxMessageProducer.send(javaxDestination, javaxMessage, deliveryMode, priority, timeToLive);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Message message, CompletionListener completionListener) throws JMSException {
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    javax.jms.CompletionListener javaxCompletionListener = new JavaxCompletionListener(completionListener);
    try {
      this.javaxMessageProducer.send(javaxMessage, javaxCompletionListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }

  }

  @Override
  public void send(Message message, int deliveryMode, int priority, long timeToLive, CompletionListener completionListener) throws JMSException {
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    javax.jms.CompletionListener javaxCompletionListener = new JavaxCompletionListener(completionListener);
    try {
      this.javaxMessageProducer.send(javaxMessage, deliveryMode, priority, timeToLive, javaxCompletionListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Destination destination, Message message, CompletionListener completionListener) throws JMSException {
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    javax.jms.CompletionListener javaxCompletionListener = new JavaxCompletionListener(completionListener);
    try {
      this.javaxMessageProducer.send(javaxDestination, javaxMessage, javaxCompletionListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive, CompletionListener completionListener)
          throws JMSException {
    javax.jms.Destination javaxDestination = Wrapper.unwrapObject(destination, javax.jms.Destination.class);
    javax.jms.Message javaxMessage = Wrapper.unwrapObject(message, javax.jms.Message.class);
    javax.jms.CompletionListener javaxCompletionListener = new JavaxCompletionListener(completionListener);
    try {
      this.javaxMessageProducer.send(javaxDestination, javaxMessage, deliveryMode, priority, timeToLive, javaxCompletionListener);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }



}
