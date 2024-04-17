package com.github.marschall.jakartajmsadapter;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import jakarta.jms.JMSException;

class WrapperTest {

  @Test
  void unwrapNull() throws JMSException {
    assertNull(Wrapper.unwrapObject(null, javax.jms.Queue.class));
  }
  
  @Test
  void unwrapUnchecked() {
    assertNull(Wrapper.unwrapUnchecked(null, javax.jms.Queue.class));
  }

}
