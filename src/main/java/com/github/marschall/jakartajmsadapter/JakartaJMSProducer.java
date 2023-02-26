package com.github.marschall.jakartajmsadapter;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.jms.CompletionListener;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.JMSProducer;
import jakarta.jms.JMSRuntimeException;
import jakarta.jms.Message;

final class JakartaJMSProducer implements JMSProducer {

  private final javax.jms.JMSProducer javaxProducer;

  JakartaJMSProducer(javax.jms.JMSProducer javaxProducer) {
    Objects.requireNonNull(javaxProducer);
    this.javaxProducer = javaxProducer;
  }

  @Override
  public JMSProducer send(Destination destination, Message message) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer send(Destination destination, String body) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer send(Destination destination, Map<String, Object> body) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer send(Destination destination, byte[] body) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer send(Destination destination, Serializable body) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setDisableMessageID(boolean value) {
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CompletionListener getAsync() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, boolean value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, byte value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, short value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, int value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, long value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, float value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, double value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, String value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setProperty(String name, Object value) {
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Destination getJMSReplyTo() {
    javax.jms.Destination javaxDestination;
    try {
      javaxDestination = this.javaxProducer.getJMSReplyTo();
    } catch (javax.jms.JMSRuntimeException e) {
      throw JMSRuntimeExceptionUtil.adaptException(e);
    }
    try {
      return JakartaDestination.fromJavax(javaxDestination);
    } catch (JMSException e) {
      throw new JMSRuntimeException("unknown destination type: " + javaxDestination.getClass());
    }
  }

}
