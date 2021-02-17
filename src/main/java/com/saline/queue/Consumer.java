package com.saline.queue;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@Bean
	public JmsListenerContainerFactory jmsFactoryTopic(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}

	@JmsListener(destination = "queue_product")
	public void onReceiveQueue(String msg) {
		System.out.println("recebendo mensagem da fila: queue_product");
		System.out.println(msg);
	}

	@JmsListener(destination = "crud_product_topic", containerFactory = "jmsFactoryTopic")
	public void onReceiverTopic(String message) {
		System.out.println("recebendo mensagem do topico");
		System.out.println(message);
	}

}