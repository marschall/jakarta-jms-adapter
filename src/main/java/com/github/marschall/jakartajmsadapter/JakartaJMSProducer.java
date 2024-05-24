package com.github.marschall.jakartajmsadapter;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.jms.CompletionListener;
import jakarta.jms.Destination;
import jakarta.jms.JMSProducer;
import jakarta.jms.Message;

final class JakartaJMSProducer implements JMSProducer {

  private final javax.jms.JMSProducer javaxProducer;
  private CompletionListener async;

  JakartaJMSProducer(javax.jms.JMSProducer javaxProducer) {
    Objects.requireNonNull(javaxProducer);
    this.javaxProducer = javaxProducer;
  }

  @Override
  public JMSProducer send(Destination destination, Message message) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    javax.jms.Message javaxMessage = Wrapper.unwrapUnchecked(message, javax.jms.Message.class);
    try {
      this.javaxProducer.send(javaxDestination, javaxMessage);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer send(Destination destination, String body) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      this.javaxProducer.send(javaxDestination, body);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer send(Destination destination, Map<String, Object> body) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      this.javaxProducer.send(javaxDestination, body);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer send(Destination destination, byte[] body) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      this.javaxProducer.send(javaxDestination, body);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer send(Destination destination, Serializable body) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(destination, javax.jms.Destination.class);
    try {
      this.javaxProducer.send(javaxDestination, body);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setDisableMessageID(boolean value) {
    try {
      this.javaxProducer.setDisableMessageID(value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public boolean getDisableMessageID() {
    try {
      return this.javaxProducer.getDisableMessageID();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setDisableMessageTimestamp(boolean value) {
    try {
      this.javaxProducer.setDisableMessageTimestamp(value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public boolean getDisableMessageTimestamp() {
    try {
      return this.javaxProducer.getDisableMessageTimestamp();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setDeliveryMode(int deliveryMode) {
    try {
      this.javaxProducer.setDeliveryMode(deliveryMode);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public int getDeliveryMode() {
    try {
      return this.javaxProducer.getDeliveryMode();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setPriority(int priority) {
    try {
      this.javaxProducer.setPriority(priority);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public int getPriority() {
    try {
      return this.javaxProducer.getPriority();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setTimeToLive(long timeToLive) {
    try {
      this.javaxProducer.setTimeToLive(timeToLive);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public long getTimeToLive() {
    try {
      return this.javaxProducer.getTimeToLive();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setDeliveryDelay(long deliveryDelay) {
    try {
      this.javaxProducer.setDeliveryDelay(deliveryDelay);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public long getDeliveryDelay() {
    try {
      return this.javaxProducer.getDeliveryDelay();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setAsync(CompletionListener completionListener) {
    javax.jms.CompletionListener javaxCompletionListener;
    if (completionListener != null) {
      javaxCompletionListener = new JavaxCompletionListener(completionListener);
    } else {
      javaxCompletionListener = null;
    }
    try {
      this.javaxProducer.setAsync(javaxCompletionListener);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    async = completionListener;
    return this;
  }

  @Override
  public CompletionListener getAsync() {
    try {
      this.javaxProducer.getAsync();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this.async;
  }

  @Override
  public JMSProducer setProperty(String name, boolean value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, byte value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, short value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, int value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, long value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, float value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, double value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, String value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer setProperty(String name, Object value) {
    try {
      this.javaxProducer.setProperty(name, value);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public JMSProducer clearProperties() {
    try {
      this.javaxProducer.clearProperties();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public boolean propertyExists(String name) {
    try {
      return this.javaxProducer.propertyExists(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getBooleanProperty(String name) {
    try {
      return this.javaxProducer.getBooleanProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public byte getByteProperty(String name) {
    try {
      return this.javaxProducer.getByteProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public short getShortProperty(String name) {
    try {
      return this.javaxProducer.getShortProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getIntProperty(String name) {
    try {
      return this.javaxProducer.getIntProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getLongProperty(String name) {
    try {
      return this.javaxProducer.getLongProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public float getFloatProperty(String name) {
    try {
      return this.javaxProducer.getFloatProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public double getDoubleProperty(String name) {
    try {
      return this.javaxProducer.getDoubleProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getStringProperty(String name) {
    try {
      return this.javaxProducer.getStringProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Object getObjectProperty(String name) {
    try {
      return this.javaxProducer.getObjectProperty(name);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Set<String> getPropertyNames() {
    try {
      return this.javaxProducer.getPropertyNames();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setJMSCorrelationIDAsBytes(byte[] correlationID) {
    try {
      this.javaxProducer.setJMSCorrelationIDAsBytes(correlationID);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public byte[] getJMSCorrelationIDAsBytes() {
    try {
      return this.javaxProducer.getJMSCorrelationIDAsBytes();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setJMSCorrelationID(String correlationID) {
    try {
      this.javaxProducer.setJMSCorrelationID(correlationID);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public String getJMSCorrelationID() {
    try {
      return this.javaxProducer.getJMSCorrelationID();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setJMSType(String type) {
    try {
      this.javaxProducer.setJMSType(type);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public String getJMSType() {
    try {
      return this.javaxProducer.getJMSType();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
  }

  @Override
  public JMSProducer setJMSReplyTo(Destination replyTo) {
    javax.jms.Destination javaxDestination = Wrapper.unwrapUnchecked(replyTo, javax.jms.Destination.class);
    try {
      this.javaxProducer.setJMSReplyTo(javaxDestination);
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return this;
  }

  @Override
  public Destination getJMSReplyTo() {
    javax.jms.Destination javaxDestination;
    try {
      javaxDestination = this.javaxProducer.getJMSReplyTo();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    return Wrapper.fromJavaxDestination(javaxDestination);
  }

}
