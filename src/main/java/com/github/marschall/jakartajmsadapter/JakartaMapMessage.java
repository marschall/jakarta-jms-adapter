package com.github.marschall.jakartajmsadapter;

import java.util.Enumeration;

import jakarta.jms.JMSException;
import jakarta.jms.MapMessage;

final class JakartaMapMessage extends JakartaMessage implements MapMessage {

  private final javax.jms.MapMessage javaxMessage;

  JakartaMapMessage(javax.jms.MapMessage javaxMessage) {
    super(javaxMessage);
    this.javaxMessage = javaxMessage;
  }

  @Override
  public boolean getBoolean(String name) throws JMSException {
    try {
      return this.javaxMessage.getBoolean(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public byte getByte(String name) throws JMSException {
    try {
      return this.javaxMessage.getByte(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public short getShort(String name) throws JMSException {
    try {
      return this.javaxMessage.getShort(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public char getChar(String name) throws JMSException {
    try {
      return this.javaxMessage.getChar(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getInt(String name) throws JMSException {
    try {
      return this.javaxMessage.getInt(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long getLong(String name) throws JMSException {
    try {
      return this.javaxMessage.getLong(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public float getFloat(String name) throws JMSException {
    try {
      return this.javaxMessage.getFloat(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public double getDouble(String name) throws JMSException {
    try {
      return this.javaxMessage.getDouble(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getString(String name) throws JMSException {
    try {
      return this.javaxMessage.getString(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public byte[] getBytes(String name) throws JMSException {
    try {
      return this.javaxMessage.getBytes(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public Object getObject(String name) throws JMSException {
    try {
      return this.javaxMessage.getObject(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public @SuppressWarnings("rawtypes") Enumeration getMapNames() throws JMSException {
    try {
      return this.javaxMessage.getMapNames();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setBoolean(String name, boolean value) throws JMSException {
    try {
      this.javaxMessage.setBoolean(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setByte(String name, byte value) throws JMSException {
    try {
      this.javaxMessage.setByte(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setShort(String name, short value) throws JMSException {
    try {
      this.javaxMessage.setShort(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setChar(String name, char value) throws JMSException {
    try {
      this.javaxMessage.setChar(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setInt(String name, int value) throws JMSException {
    try {
      this.javaxMessage.setInt(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setLong(String name, long value) throws JMSException {
    try {
      this.javaxMessage.setLong(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setFloat(String name, float value) throws JMSException {
    try {
      this.javaxMessage.setFloat(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setDouble(String name, double value) throws JMSException {
    try {
      this.javaxMessage.setDouble(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setString(String name, String value) throws JMSException {
    try {
      this.javaxMessage.setString(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setBytes(String name, byte[] value) throws JMSException {
    try {
      this.javaxMessage.setBytes(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setBytes(String name, byte[] value, int offset, int length) throws JMSException {
    try {
      this.javaxMessage.setBytes(name, value, offset, length);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void setObject(String name, Object value) throws JMSException {
    try {
      this.javaxMessage.setObject(name, value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean itemExists(String name) throws JMSException {
    try {
      return this.javaxMessage.itemExists(name);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
