/**
 * 
 */
package com.cg.helloworldcktBreakerwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ugawari
 *
 */
@Service
public class HelloWorldService {

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * public HelloWorldService(RestTemplate rest) { this.restTemplate = rest; }
	 */
	 
	 @HystrixCommand(fallbackMethod = "reliable")
	  public String hollo(Model model) {
		 ResponseEntity<String> word = restTemplate.getForEntity("http://localhost:8090/helloservices", String.class);
		// return new ModelAndView("index", "message", word.getBody());
		 System.out.println(word.getBody());
		 model.addAttribute("message", word.getBody());
		 return "index";
	  }

	  public String reliable(Model model) {
	   // return new ModelAndView("index", "message", "Good Morning !!!");
		  model.addAttribute("message", "Good Morning !!!");
		return "index";
	  }
}
