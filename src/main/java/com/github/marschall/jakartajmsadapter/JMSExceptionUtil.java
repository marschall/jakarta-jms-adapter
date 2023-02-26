package com.github.marschall.jakartajmsadapter;

import jakarta.jms.IllegalStateException;
import jakarta.jms.InvalidClientIDException;
import jakarta.jms.InvalidDestinationException;
import jakarta.jms.InvalidSelectorException;
import jakarta.jms.JMSException;
import jakarta.jms.JMSSecurityException;
import jakarta.jms.MessageEOFException;
import jakarta.jms.MessageFormatException;
import jakarta.jms.MessageNotReadableException;
import jakarta.jms.MessageNotWriteableException;
import jakarta.jms.ResourceAllocationException;
import jakarta.jms.TransactionInProgressException;
import jakarta.jms.TransactionRolledBackException;

final class JMSExceptionUtil {

  private JMSExceptionUtil() {
    throw new AssertionError("not instantiable");
  }

  static JMSException adaptException(javax.jms.JMSException e) {
    if (e instanceof javax.jms.IllegalStateException illegalStateException) {
      return new IllegalStateException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidClientIDException invalidClientIDException) {
      return new InvalidClientIDException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidDestinationException invalidDestinationException) {
      return new InvalidDestinationException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.InvalidSelectorException invalidSelectorException) {
      return new InvalidSelectorException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.JMSSecurityException jmsSecurityException) {
      return new JMSSecurityException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageEOFException messageEOFException) {
      return new MessageEOFException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageFormatException messageFormatException) {
      return new MessageFormatException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageNotReadableException messageNotReadableException) {
      return new MessageNotReadableException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.MessageNotWriteableException messageNotWriteableException) {
      return new MessageNotWriteableException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.ResourceAllocationException resourceAllocationException) {
      return new ResourceAllocationException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.TransactionInProgressException transactionInProgressException) {
      return new TransactionInProgressException(e.getMessage(), e.getErrorCode(), e);
    } else if (e instanceof javax.jms.TransactionRolledBackException transactionRolledBackException) {
      return new TransactionRolledBackException(e.getMessage(), e.getErrorCode(), e);
    } else {
      return new JMSException(e.getMessage(), e.getErrorCode(), e);
    }
  }

}
