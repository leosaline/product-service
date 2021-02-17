package com.saline.naton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saline.queue.MessageSender;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MensagemController {
	@Autowired
	MessageSender arquivoSender;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Send a single message through queue") })
	@GetMapping(value = "/queue", produces = "application/json")
	public String enviaMensagemQueue(@RequestBody String mensagem) {
		System.out.println("preparando envio da mensagem");

		arquivoSender.sendToQueue(mensagem);

		return "mensagem enviada";
	}
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Send a single message through topic") })
	@GetMapping(value = "/topic", produces = "application/json")
	public String enviaMensagemTopic(@RequestBody String mensagem) {
		System.out.println("preparando envio da mensagem");

		arquivoSender.sendToTopic(mensagem);

		return "mensagem enviada";
	}	
}
