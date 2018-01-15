# Event Driven Software Applications using Containers with Spring-Boot and Active MQ

## Prerequisites
### Tools
* \*nix (Ubuntu 16.04 LTS)
* JDK + Java IDE (Java 8, Eclipse Oxygen 2)
* Maven (3.3.9)
* Spring-Framework (4.3.13) and Spring-Boot (1.5.9)
* Active MQ (5.x)
* Docker Engine CE (17.12.0)
* Docker Compose (1.18.0)
### Knowledge
* Java.
* Basic Knowledge about the Spring-Framework, what it does and how it's doing.
* Basic Knowledge about Java Messaging (JMS)
* Plus
  * Build and Dependency-Management System (Maven)
  * Containerisation (Docker + Docker-Compose)

The Plus is required to get the Demo up-and-running, but not for understanding of the main points.

## Motivation
If you start developing Event Driven Applications within Spring Ecosystem, your Start Point should be [spring.io][1]. Out-of-the Box it is capable to sent simple Messages like Strings or Numbers. But, what if you require custom Configurations to use some more advanced techniques?

Spring Integration uses a JMS-Template, which needs some customization if you want to serialize JSON to be send to an external Active MQ Instance. First, inject the ```org.apache.activemq.ActiveMQConnectionFactory``` to configure the Active MQ-Connection as required.  
Second, provide a more elaborated ```org.springframework.jms.support.converter.MessageConverter```, in our case an Instance of ```org.springframework.jms.support.converter.MappingJackson2MessageConverter```. Both Converters are Part of Spring's JMS Support, but it is required to add the actual Converter Dependencies from ```com.fasterxml.jackson.core``` to your Project.  

For Example, a Maven-based Setting requires the following entries:
```xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-activemq</artifactId>
	</dependency>
	<dependency>
		<groupId>org.apache.activemq</groupId>
		<artifactId>activemq-broker</artifactId>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
	</dependency>
```
Furthermore, your Project must contain the Spring-Boot Parent:
```xml
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.9.RELEASE</version>
	</parent>
```
See the both Projects - Producer and Consumer - for more Details.

## Start
When you have all the Tools at hand, just call 
``` ./start.sh ``` at the Root-Folder, sit back and view all three Containers fire up. After a short amount of Time, you will see the ```msg-producer``` publishing every 5 Seconds a new Notification, that gets consumed immediatly by the ```msg-consumer``` Container.  
Press ```Ctrl+C``` to stop the Containers. 


[1]: https://spring.io/guides/gs/messaging-jms/
