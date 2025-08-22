package com.github.marschall.jakartajmsadapter;

import jakarta.jms.IllegalStateRuntimeException;
import jakarta.jms.InvalidClientIDRuntimeException;
import jakarta.jms.InvalidDestinationRuntimeException;
import jakarta.jms.InvalidSelectorRuntimeException;
import jakarta.jms.JMSRuntimeException;
import jakarta.jms.JMSSecurityRuntimeException;
import jakarta.jms.MessageFormatRuntimeException;
import jakarta.jms.MessageNotWriteableRuntimeException;
import jakarta.jms.ResourceAllocationRuntimeException;
import jakarta.jms.TransactionInProgressRuntimeException;
import jakarta.jms.TransactionRolledBackRuntimeException;

final class JMSRuntimeExceptionUtil {

  private JMSRuntimeExceptionUtil() {
    throw new AssertionError("not instantiable");
  }

  static JMSRuntimeException adaptException(javax.jms.JMSRuntimeException e) {
    if (e instanceof javax.jms.IllegalStateRuntimeException) {
      return new IllegalStateRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidClientIDRuntimeException) {
      return new InvalidClientIDRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidDestinationRuntimeException) {
      return new InvalidDestinationRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidSelectorRuntimeException) {
      return new InvalidSelectorRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.JMSSecurityRuntimeException) {
      return new JMSSecurityRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageFormatRuntimeException) {
      return new MessageFormatRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageNotWriteableRuntimeException) {
      return new MessageNotWriteableRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.ResourceAllocationRuntimeException) {
      return new ResourceAllocationRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.TransactionInProgressRuntimeException) {
      return new TransactionInProgressRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.TransactionRolledBackRuntimeException) {
      return new TransactionRolledBackRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else {
      return new JMSRuntimeException(e.getMessage(), e.getErrorCode(), e);
    }
  }

}
