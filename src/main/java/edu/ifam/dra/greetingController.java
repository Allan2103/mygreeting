package edu.ifam.dra;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //this annotation tells this class that any object returned in this methods will return a .json

public class greetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/Greeting")
	public greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new greeting(counter.incrementAndGet(), String.format(template, name));
	}
}