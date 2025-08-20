package com.github.marschall.jakartajmsadapter;

import java.util.Objects;

import jakarta.jms.Destination;

abstract sealed class JakartaDestination implements Destination, Wrapper
    permits JakartaQueue, JakartaTopic, JakartaQueueTopic {

  private final javax.jms.Destination javaxDestination;

  JakartaDestination(javax.jms.Destination javaxDestination) {
    Objects.requireNonNull(javaxDestination);
    this.javaxDestination = javaxDestination;
  }

  @Override
  public Object getJavaxObject() {
    return this.javaxDestination;
  }

  @Override
  public String toString() {
    return this.javaxDestination.toString();
  }

}
