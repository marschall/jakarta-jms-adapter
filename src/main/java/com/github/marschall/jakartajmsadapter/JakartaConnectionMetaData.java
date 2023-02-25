package com.github.marschall.jakartajmsadapter;

import java.util.Enumeration;
import java.util.Objects;

import jakarta.jms.ConnectionMetaData;
import jakarta.jms.JMSException;

final class JakartaConnectionMetaData implements ConnectionMetaData {

  private final javax.jms.ConnectionMetaData javaxConnectionMetaData;

  JakartaConnectionMetaData(javax.jms.ConnectionMetaData javaxConnectionMetaData) {
    Objects.requireNonNull(javaxConnectionMetaData);
    this.javaxConnectionMetaData = javaxConnectionMetaData;
  }

  @Override
  public String getJMSVersion() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getJMSVersion();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getJMSMajorVersion() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getJMSMajorVersion();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getJMSMinorVersion() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getJMSMinorVersion();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getJMSProviderName() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getJMSProviderName();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public String getProviderVersion() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getProviderVersion();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getProviderMajorVersion() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getProviderMajorVersion();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public int getProviderMinorVersion() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getProviderMinorVersion();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

  @Override
  public @SuppressWarnings("rawtypes") Enumeration getJMSXPropertyNames() throws JMSException {
    try {
      return this.javaxConnectionMetaData.getJMSXPropertyNames();
    } catch (javax.jms.JMSException e) {
      throw JMSExceptionUtil.adaptException(e);
    }
  }

}
