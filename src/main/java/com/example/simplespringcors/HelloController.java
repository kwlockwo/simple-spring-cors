package com.example.simplespringcors;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping({"/hello", "/hello-authenticated"})
    @CrossOrigin
	public Hello hello(@RequestParam(required = false, defaultValue = "World") String name) {
		LOGGER.info("==== get hello ====");
		return new Hello(counter.incrementAndGet(), String.format(TEMPLATE, name));
	}
}
