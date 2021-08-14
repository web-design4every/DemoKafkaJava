package com.kafkaexample.kafkademo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private final Producer producer;

	@Autowired
	private Consumer consumer;
	
    @Autowired
    public Controller(Producer producer) {
        this.producer = producer;
    }
    
    @PostMapping("/publish")
    public String messageToTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
        return message;
    }
    
    @GetMapping("/publish")
    public String getMessage(){
    	consumer.getAllMessage();
        return "success";
    }
}
