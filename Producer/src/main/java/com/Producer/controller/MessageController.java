package com.Producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Producer.service.MessageReceiver;
import com.Producer.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	MessageService    service;
	
	@Autowired
	MessageReceiver   receiver;
	
	@GetMapping("/sendMessage")
	public  String    produceMessage(@RequestParam("publish")String   message)
	{
		
		service.sendMessage(message);
		return "Message sent to kafka...";
	}
	
	
	@GetMapping("/receiveMessage")
	public   String   receiveMessage() {
		return  receiver.returnMessage();
	}
}
