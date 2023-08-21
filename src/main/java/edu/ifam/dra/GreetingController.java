package edu.ifam.dra;



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //this annotation tells this class that any object returned in this methods will return a .json

public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private ArrayList<Greeting> greetings = new ArrayList<Greeting>();
	
	@GetMapping("/Greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		greetings.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/Greetings")
	public ArrayList<Greeting> greetings() {
		return greetings;
	}
}


