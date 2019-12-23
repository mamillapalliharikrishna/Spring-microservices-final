package com.Producer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {
	 String  message;
	
	@KafkaListener(topics="sample-topic",groupId="groupid")
	public  void  receiveMessage(String  message) {
		this.message=message;
	}
	
	public   String   returnMessage() {
		return  message;
	}

}
