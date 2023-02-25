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
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public JMSProducer setDisableMessageTimestamp(boolean value) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean getDisableMessageTimestamp() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public JMSProducer setDeliveryMode(int deliveryMode) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getDeliveryMode() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public JMSProducer setPriority(int priority) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getPriority() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public JMSProducer setTimeToLive(long timeToLive) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long getTimeToLive() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public JMSProducer setDeliveryDelay(long deliveryDelay) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long getDeliveryDelay() {
    // TODO Auto-generated method stub
    return 0;
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
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean getBooleanProperty(String name) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public byte getByteProperty(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public short getShortProperty(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getIntProperty(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long getLongProperty(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public float getFloatProperty(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getDoubleProperty(String name) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String getStringProperty(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getObjectProperty(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> getPropertyNames() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setJMSCorrelationIDAsBytes(byte[] correlationID) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public byte[] getJMSCorrelationIDAsBytes() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setJMSCorrelationID(String correlationID) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getJMSCorrelationID() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setJMSType(String type) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getJMSType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public JMSProducer setJMSReplyTo(Destination replyTo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Destination getJMSReplyTo() {
    // TODO Auto-generated method stub
    return null;
  }

}
