package com.beamofsoul.cloud.bunny.receiver;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.beamofsoul.cloud.bunny.sender.SinkSender;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * 该注解用来指定一个或多个定义了@Input或@Output注解的接口，以此实现对消息通道(Channel)的绑定。
 * Sink接口是Stream中默认实现的对输入消息通道绑定的定义，它通过@Input注解绑定了一个名为input的通道。
 * 除了Sink之外，Source接口是Stream中默认实现的对output输出消息通道绑定的定义。
 * 而Processor接口则是通过继承方式实现了Sink和Source两个接口的结合。
 * 当需要为@EnableBinding指定多个接口来绑定消息通道的时候，
 * 可以定义@EnableBinding(value={Sink.class, Source.class})。
 */
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {

	@StreamListener(Sink.INPUT) // 将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应监听的消息通道名
	public void reveiver(Object payload) {
		log.info("Receiver: " + payload);
	}
}
