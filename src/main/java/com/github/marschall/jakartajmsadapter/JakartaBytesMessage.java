package com.github.marschall.jakartajmsadapter;

import jakarta.jms.BytesMessage;
import jakarta.jms.JMSException;

final class JakartaBytesMessage extends JakartaMessage implements BytesMessage {

  private final javax.jms.BytesMessage javaxMessage;

  JakartaBytesMessage(javax.jms.BytesMessage javaxMessage) {
    super(javaxMessage);
    this.javaxMessage = javaxMessage;
  }

  @Override
  public long getBodyLength() throws JMSException {
    try {
      return javaxMessage.getBodyLength();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public boolean readBoolean() throws JMSException {
    try {
      return javaxMessage.readBoolean();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public byte readByte() throws JMSException {
    try {
      return javaxMessage.readByte();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int readUnsignedByte() throws JMSException {
    try {
      return javaxMessage.readUnsignedByte();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public short readShort() throws JMSException {
    try {
      return javaxMessage.readShort();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int readUnsignedShort() throws JMSException {
    try {
      return javaxMessage.readUnsignedShort();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public char readChar() throws JMSException {
    try {
      return javaxMessage.readChar();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int readInt() throws JMSException {
    try {
      return javaxMessage.readInt();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public long readLong() throws JMSException {
    try {
      return javaxMessage.readLong();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public float readFloat() throws JMSException {
    try {
      return javaxMessage.readFloat();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public double readDouble() throws JMSException {
    try {
      return javaxMessage.readDouble();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String readUTF() throws JMSException {
    try {
      return javaxMessage.readUTF();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int readBytes(byte[] value) throws JMSException {
    try {
      return javaxMessage.readBytes(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int readBytes(byte[] value, int length) throws JMSException {
    try {
      return javaxMessage.readBytes(value, length);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeBoolean(boolean value) throws JMSException {
    try {
      javaxMessage.writeBoolean(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeByte(byte value) throws JMSException {
    try {
      javaxMessage.writeByte(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeShort(short value) throws JMSException {
    try {
      javaxMessage.writeShort(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeChar(char value) throws JMSException {
    try {
      javaxMessage.writeChar(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeInt(int value) throws JMSException {
    try {
      javaxMessage.writeInt(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeLong(long value) throws JMSException {
    try {
      javaxMessage.writeLong(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeFloat(float value) throws JMSException {
    try {
      javaxMessage.writeFloat(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeDouble(double value) throws JMSException {
    try {
      javaxMessage.writeDouble(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeUTF(String value) throws JMSException {
    try {
      javaxMessage.writeUTF(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeBytes(byte[] value) throws JMSException {
    try {
      javaxMessage.writeBytes(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeBytes(byte[] value, int offset, int length) throws JMSException {
    try {
      javaxMessage.writeBytes(value, offset, length);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void writeObject(Object value) throws JMSException {
    try {
      javaxMessage.writeObject(value);
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public void reset() throws JMSException {
    try {
      javaxMessage.reset();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
