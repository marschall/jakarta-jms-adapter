package com.github.marschall.jakartajmsadapter;

import jakarta.jms.ConnectionFactory;

public final class JakartaConnectionFactory implements ConnectionFactory {

  private final javax.jms.ConnectionFactory javaxConnectionFactory;

  public JakartaConnectionFactory(javax.jms.ConnectionFactory javaxConnectionFactory) {
    this.javaxConnectionFactory = javaxConnectionFactory;
  }

}
