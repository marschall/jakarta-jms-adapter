package com.github.marschall.jakartajmsadapter;

import java.util.Enumeration;
import java.util.Objects;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;

sealed class JakartaMessage implements Message, Wrapper
    permits JakartaBytesMessage, JakartaMapMessage, JakartaObjectMessage, JakartaStreamMessage, JakartaTextMessage {

  private final javax.jms.Message javaxMessage;

  JakartaMessage(javax.jms.Message javaxMessage) {
    Objects.requireNonNull(javaxMessage);
    this.javaxMessage = javaxMessage;
  }

  @Override
  public String getJMSMessageID() throws JMSException {
    try {
      return this.javaxMessage.getJMSMessageID();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSMessageID(String id) throws JMSException {
    try {
      this.javaxMessage.setJMSMessageID(id);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getJMSTimestamp() throws JMSException {
    try {
      return this.javaxMessage.getJMSTimestamp();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSTimestamp(long timestamp) throws JMSException {
    try {
      this.javaxMessage.setJMSTimestamp(timestamp);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
    try {
      return this.javaxMessage.getJMSCorrelationIDAsBytes();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSCorrelationIDAsBytes(byte[] correlationID) throws JMSException {
    try {
      this.javaxMessage.setJMSCorrelationIDAsBytes(correlationID);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSCorrelationID(String correlationID) throws JMSException {
    try {
      this.javaxMessage.setJMSCorrelationID(correlationID);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getJMSCorrelationID() throws JMSException {
    try {
      return this.javaxMessage.getJMSCorrelationID();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Destination getJMSReplyTo() throws JMSException {
    try {
      return JakartaDestination.fromJavax(this.javaxMessage.getJMSReplyTo());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSReplyTo(Destination replyTo) throws JMSException {
    try {
      this.javaxMessage.setJMSReplyTo(Wrapper.unwrapObject(replyTo, javax.jms.Destination.class));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Destination getJMSDestination() throws JMSException {
    try {
      return JakartaDestination.fromJavax(this.javaxMessage.getJMSDestination());
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSDestination(Destination destination) throws JMSException {
    try {
      this.javaxMessage.setJMSDestination(Wrapper.unwrapObject(destination, javax.jms.Destination.class));
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getJMSDeliveryMode() throws JMSException {
    try {
      return this.javaxMessage.getJMSDeliveryMode();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
    try {
      this.javaxMessage.setJMSDeliveryMode(deliveryMode);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getJMSRedelivered() throws JMSException {
    try {
      return this.javaxMessage.getJMSRedelivered();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSRedelivered(boolean redelivered) throws JMSException {
    try {
      this.javaxMessage.setJMSRedelivered(redelivered);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getJMSType() throws JMSException {
    try {
      return this.javaxMessage.getJMSType();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSType(String type) throws JMSException {
    try {
      this.javaxMessage.setJMSType(type);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getJMSExpiration() throws JMSException {
    try {
      return this.javaxMessage.getJMSExpiration();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSExpiration(long expiration) throws JMSException {
    try {
      this.javaxMessage.setJMSExpiration(expiration);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getJMSDeliveryTime() throws JMSException {
    try {
      return this.javaxMessage.getJMSDeliveryTime();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSDeliveryTime(long deliveryTime) throws JMSException {
    try {
      this.javaxMessage.setJMSDeliveryTime(deliveryTime);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getJMSPriority() throws JMSException {
    try {
      return this.javaxMessage.getJMSPriority();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setJMSPriority(int priority) throws JMSException {
    try {
      this.javaxMessage.setJMSPriority(priority);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void clearProperties() throws JMSException {
    try {
      this.javaxMessage.clearProperties();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean propertyExists(String name) throws JMSException {
    try {
      return this.javaxMessage.propertyExists(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean getBooleanProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getBooleanProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public byte getByteProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getByteProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public short getShortProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getShortProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getIntProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getIntProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getLongProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getLongProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public float getFloatProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getFloatProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public double getDoubleProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getDoubleProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getStringProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getStringProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Object getObjectProperty(String name) throws JMSException {
    try {
      return this.javaxMessage.getObjectProperty(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Enumeration getPropertyNames() throws JMSException {
    try {
      return this.javaxMessage.getPropertyNames();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setBooleanProperty(String name, boolean value) throws JMSException {
    try {
      this.javaxMessage.setBooleanProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setByteProperty(String name, byte value) throws JMSException {
    try {
      this.javaxMessage.setByteProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setShortProperty(String name, short value) throws JMSException {
    try {
      this.javaxMessage.setShortProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setIntProperty(String name, int value) throws JMSException {
    try {
      this.javaxMessage.setIntProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setLongProperty(String name, long value) throws JMSException {
    try {
      this.javaxMessage.setLongProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setFloatProperty(String name, float value) throws JMSException {
    try {
      this.javaxMessage.setFloatProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setDoubleProperty(String name, double value) throws JMSException {
    try {
      this.javaxMessage.setDoubleProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setStringProperty(String name, String value) throws JMSException {
    try {
      this.javaxMessage.setStringProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setObjectProperty(String name, Object value) throws JMSException {
    try {
      this.javaxMessage.setObjectProperty(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void acknowledge() throws JMSException {
    try {
      this.javaxMessage.acknowledge();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void clearBody() throws JMSException {
    try {
      this.javaxMessage.clearBody();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }

  }

  @Override
  public <T> T getBody(Class<T> c) throws JMSException {
    try {
      return this.javaxMessage.getBody(c);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean isBodyAssignableTo(@SuppressWarnings("rawtypes") Class c) throws JMSException {
    try {
      return this.javaxMessage.isBodyAssignableTo(c);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Object getJavaxObject() {
    return this.javaxMessage;
  }

  static Message fromJavax(javax.jms.Message message) {
    if (message instanceof javax.jms.BytesMessage bytesMessage) {
      return new JakartaBytesMessage(bytesMessage);
    } else if (message instanceof javax.jms.MapMessage mapMessage) {
      return new JakartaMapMessage(mapMessage);
    } else if (message instanceof javax.jms.ObjectMessage objectMessage) {
      return new JakartaObjectMessage(objectMessage);
    } else if (message instanceof javax.jms.StreamMessage streamMessage) {
      return new JakartaStreamMessage(streamMessage);
    } else if (message instanceof javax.jms.TextMessage textMessage) {
      return new JakartaTextMessage(textMessage);
    } else {
      return new JakartaMessage(message);
    }
  }

}
