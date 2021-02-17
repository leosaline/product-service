package com.saline.queue;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	private Queue queueCompany = new ActiveMQQueue("queue_company");
	private Topic topicProduct = new ActiveMQTopic("crud_product_topic");

	public void sendToQueue(String message) {		
		System.out.println("enviando mensagem para fila 'queue_company' " + message);
		this.jmsMessagingTemplate.convertAndSend(this.queueCompany, message);
	}
	
	public void sendToTopic(String message) {
		System.out.println("enviando mensagem para fila 'crud_product_topic' " + message);
		this.jmsMessagingTemplate.convertAndSend(this.topicProduct, message);
	}
}
