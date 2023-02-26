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
    if (e instanceof javax.jms.IllegalStateRuntimeException illegalStateException) {
      return new IllegalStateRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidClientIDRuntimeException invalidClientIDException) {
      return new InvalidClientIDRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidDestinationRuntimeException invalidDestinationException) {
      return new InvalidDestinationRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidSelectorRuntimeException invalidSelectorException) {
      return new InvalidSelectorRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.JMSSecurityRuntimeException jmsSecurityException) {
      return new JMSSecurityRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageFormatRuntimeException messageFormatException) {
      return new MessageFormatRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageNotWriteableRuntimeException messageNotWriteableException) {
      return new MessageNotWriteableRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.ResourceAllocationRuntimeException resourceAllocationException) {
      return new ResourceAllocationRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.TransactionInProgressRuntimeException transactionInProgressException) {
      return new TransactionInProgressRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.TransactionRolledBackRuntimeException transactionRolledBackException) {
      return new TransactionRolledBackRuntimeException(e.getMessage(), e.getErrorCode(), e);
    } else {
      return new JMSRuntimeException(e.getMessage(), e.getErrorCode(), e);
    }
  }

}
