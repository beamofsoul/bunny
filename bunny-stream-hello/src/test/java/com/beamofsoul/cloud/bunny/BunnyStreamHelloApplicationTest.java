package com.beamofsoul.cloud.bunny;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beamofsoul.cloud.bunny.sender.SinkSender;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BunnyStreamHelloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BunnyStreamHelloApplicationTest extends TestCase {
	
	@Autowired
	private SinkSender sinkSender;
	
	@Autowired
	private MessageChannel input;
	
	@Test
	public void contextLoads() {
		sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
		input.send(MessageBuilder.withPayload("From MessageChannel").build());
	}
}
