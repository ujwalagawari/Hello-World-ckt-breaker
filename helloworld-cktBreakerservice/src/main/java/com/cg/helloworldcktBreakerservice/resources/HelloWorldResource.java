/**
 * 
 */
package com.cg.helloworldcktBreakerservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ugawari
 *
 */
@RestController
@RequestMapping("/helloservices")
public class HelloWorldResource {
	
	@GetMapping
	public String hello() {
		return "Hello World !!!";
	}

}
