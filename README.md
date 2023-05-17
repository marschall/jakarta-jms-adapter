Jakarta JMS Adapter
===================

Adapts a `javax.jms` JMS provider to a `jakarta.jms` JMS provider.

This is helpful for applications that want to use Jakarta EE 9+ (eg. Spring 6 / Spring Boot 3) but have JMS adapters that are still on the Java EE APIs.

Usage
-----

```java
javax.jms.ConnectionFactory javaxConnectionFactory = ...;
jakarta.jms.ConnectionFactory jakartaConnectionFactory = new JakartaConnectionFactory(javaxConnectionFactory);
```

The project requires JDK 17 and makes extensive use of sealed classes.
