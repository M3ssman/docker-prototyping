package com.github.m3ssman.spring.activemq;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.m3ssman.spring.activemq.model.Notification;

@Component
public class Producer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

	private AtomicInteger nr = new AtomicInteger(1);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(initialDelay = 500, fixedDelay = 5000)
	public void send() {
		int n = nr.getAndIncrement();
		LOGGER.info("create notification no '{}'", n);
		Notification note = new Notification("info@example.com", "Hello Nr: " + n);
		jmsTemplate.convertAndSend("notification", note);
		LOGGER.info("notification '{}' sent", note);
	}
}
