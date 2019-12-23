package com.Producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	KafkaTemplate<String,String>    kafkaTemplate;
	String  topicName="sample-topic";
	
	public  void   sendMessage(String  message) {
		kafkaTemplate.send(topicName,message);
	}

}
