package com.gogo.services.BookDatabase.hi;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetHello {
	
	@Autowired
	private AirlineServices airlineservices;
	
	@RequestMapping("/hi")
	public String helloPrint() {
		return "Hi";
	}
	
	@RequestMapping("/airlines")
	public List<Airline> Airlines() {
		return airlineservices.AirlineMethod() ;
	}
	
	@RequestMapping("/airlines/{id}")
	public Airline SpecificAirline(@PathVariable String id){
		return airlineservices.SpecificAirline(id);
	}

}
