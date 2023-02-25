Jakarta JMS Adapter
===================

Adapts a `javax.jms` JMS provider to a `jakarta.jms` JMS provider.


Usage
-----

```java
javax.jms.ConnectionFactory javaxConnectionFactory = ...;
jakarta.jms.ConnectionFactory jakartaConnectionFactory = new JakartaConnectionFactory(javaxConnectionFactory);
```
