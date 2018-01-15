package com.github.m3ssman.spring.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.github.m3ssman.spring.activemq.model.Notification;

@Component
public class Consumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${activemq.queue.notification}")
    public void receiveMessage(Notification note) {
    	LOGGER.info("Received note '{}'", note);
    }

}
