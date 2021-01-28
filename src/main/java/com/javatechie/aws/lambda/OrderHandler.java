package com.javatechie.aws.lambda;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
//String as input Obejct as a list of Order items
public class OrderHandler extends SpringBootRequestHandler<String, Object>{
	//SpringBootRequestHandler help serialise and deserialise an object
}
