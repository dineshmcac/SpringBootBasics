package com.gogo.services.BookDatabase.hi;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {
	
	@Autowired
	private FamilyService familyservices;
	
	@RequestMapping("/multipleof/{value}")
	public Map<String, String> helloPrint(@PathVariable int value) {
		//StringBuilder appendString = new StringBuilder("API");
		Map<String,String> hi =new LinkedHashMap<String,String>();
		
		for (int i = 1; i <= value; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				hi.put(Integer.toString(i), "Multiple of 3 & 5");
				//appendString.append(Integer.toString(i) + " - Multiple of 3 & 5" + System.getProperty("line.separator") );
				//System.out.println(i + " - Multiple of 3 & 5");
			else if (i % 3 == 0)
				hi.put(Integer.toString(i), "Multiple of 3");
				//appendString.append(Integer.toString(i)+ " - Multiple of 3 " + System.getProperty("line.separator"));
				//System.out.println(i + " - Multiple of 3");
			else if (i % 5 == 0)
				hi.put(Integer.toString(i), "Multiple of 5");
				//appendString.append(Integer.toString(i)+ " - Multiple of 5" + System.getProperty("line.separator"));
				
				//System.out.println(i + " - Multiple of 5");
			else {
				hi.put(Integer.toString(i), " Not Multiple of 3 & 5");
				//appendString.append(Integer.toString(i) + System.getProperty("line.separator"));
			}
				//System.out.println(i);
		}
		
		 return hi;
	}
	
	@RequestMapping("/familydetails")
	public List<FamilyDetail> GetFamily() {
		return familyservices.GetFamilyDetails() ;
	}
	
	@RequestMapping(value ="/familydetails/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FamilyDetail> SpecificFamily(@PathVariable String id){
		FamilyDetail fes = familyservices.SpecificFamilyMember(id);
		return new ResponseEntity<FamilyDetail>(fes, HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addfamily"	)
	public void postMethod(@RequestBody FamilyDetail body){
		familyservices.addFamily(body);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatefamily/{id}")
	public void PUTMethod(@PathVariable String id, @RequestBody FamilyDetail body){
		familyservices.updateFamily(id,body);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletefamily/{id}"	)
	public void DeleteMethod(@PathVariable String id){
		familyservices.deleteFamily(id);
	}

}
