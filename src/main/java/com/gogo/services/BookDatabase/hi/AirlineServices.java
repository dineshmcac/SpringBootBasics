package com.gogo.services.BookDatabase.hi;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AirlineServices {
	
	List<Airline> airline =Arrays.asList(new Airline("2","jjj","hhhh"),
			new Airline("1","jjj","hhhh"));
	
	public List<Airline> AirlineMethod(){
		return airline;
	}
	
	public Airline SpecificAirline(String id){
		return airline.stream().filter(a -> a.getId().equals(id)).findFirst().get();
	}

}
