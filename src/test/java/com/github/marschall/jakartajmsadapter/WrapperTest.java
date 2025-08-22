package com.github.marschall.jakartajmsadapter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.Topic;

class WrapperTest {

  @Test
  void unwrapNull() throws JMSException {
    assertNull(Wrapper.unwrapObject(null, javax.jms.Queue.class));
  }

  @Test
  void unwrapUnchecked() {
    assertNull(Wrapper.unwrapUnchecked(null, javax.jms.Queue.class));
  }

  @Test
  void queueAndTopic() throws JMSException {
    QueueAndTopic javaxDestination = new QueueAndTopic();
    Destination destination = Wrapper.fromJavaxDestination(javaxDestination);
    assertTrue(destination instanceof Queue);
    assertTrue(destination instanceof Topic);
    assertSame(javaxDestination, Wrapper.unwrapObject(destination, javax.jms.Queue.class));
    assertSame(javaxDestination, Wrapper.unwrapObject(destination, javax.jms.Topic.class));
  }

  static final class QueueAndTopic implements javax.jms.Queue, javax.jms.Topic {

    @Override
    public String getTopicName() throws javax.jms.JMSException {
      return "TopicName";
    }

    @Override
    public String getQueueName() throws javax.jms.JMSException {
      return "QueueName";
    }

    @Override
    public String toString() {
      return "QueueAndTopic";
    }

  }

}
