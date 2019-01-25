/**
 * 
 */
package com.cg.helloworldcktBreakerwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ugawari
 *
 */

@Controller
@EnableCircuitBreaker
public class HelloWorldController {

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping("/hello")
	public String name(Model model) {
		System.out.println("ujjj");
		/*
		 * ResponseEntity<String> word =
		 * restTemplate.getForEntity("http://localhost:8090/helloservices",
		 * String.class); return word.getBody();
		 */
		return helloWorldService.hollo(model);
	}

}
